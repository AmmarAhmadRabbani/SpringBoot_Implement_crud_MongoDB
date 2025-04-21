package com.te.crudmongodb.service;

import java.util.List;

import com.te.crudmongodb.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto addEmployee(EmployeeDto employeeDto);

	public List<EmployeeDto> getEmployee();

	public EmployeeDto updateEmployee(EmployeeDto employeeDto);

	public EmployeeDto deleteEmployee(Long userId);

}
