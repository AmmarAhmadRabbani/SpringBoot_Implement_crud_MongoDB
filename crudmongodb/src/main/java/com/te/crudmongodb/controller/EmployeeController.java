package com.te.crudmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.crudmongodb.dto.EmployeeDto;
import com.te.crudmongodb.response.SuccessResponse;
import com.te.crudmongodb.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<SuccessResponse> addEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto addEmployee = employeeService.addEmployee(employeeDto);
		if (addEmployee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "added successfully", addEmployee), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "addding failed", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<SuccessResponse> getEmployee() {
		List<EmployeeDto> employee = employeeService.getEmployee();
		if (employee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "successfull", employee), HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "failed", null), HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updateEmployee/{userId}")
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto updateEmployee = employeeService.updateEmployee(employeeDto);
		if (updateEmployee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "updated", updateEmployee), HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "updation failed", null), HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteEmployee/{userId}")
	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable Long userId) {
		EmployeeDto deleteEmployee = employeeService.deleteEmployee(userId);
		if (deleteEmployee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "deleted", deleteEmployee), HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "deletion failed", null), HttpStatus.BAD_REQUEST);
	}

}
