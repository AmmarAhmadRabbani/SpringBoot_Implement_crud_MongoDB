package com.te.crudmongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.crudmongodb.dto.EmployeeDto;
import com.te.crudmongodb.entity.Employee;
import com.te.crudmongodb.exception.UserNotFoundException;
import com.te.crudmongodb.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		if (employeeDto != null) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDto, employee);
			Employee saveEmployee = employeeRepository.save(employee);
			EmployeeDto employeeDto2 = new EmployeeDto();
			BeanUtils.copyProperties(saveEmployee, employeeDto2);
			return employeeDto2;

		}
		throw new UserNotFoundException("invalid employee id");
	}

	@Override
	public List<EmployeeDto> getEmployee() {
		List<EmployeeDto> employeeDtosList = new ArrayList<>();
		List<Employee> findAll = employeeRepository.findAll();
		if (!findAll.isEmpty()) {
			findAll.forEach(i -> {
				EmployeeDto dto = new EmployeeDto();
				BeanUtils.copyProperties(i, dto);
				employeeDtosList.add(dto);
			});
		}
		throw new UserNotFoundException("employees not found");
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		Optional<Employee> findById = employeeRepository.findById(employeeDto.getUserId());
		if (findById.isPresent()) {
			BeanUtils.copyProperties(employeeDto, findById.get());
			employeeRepository.save(findById.get());
			BeanUtils.copyProperties(findById.get(), employeeDto);
			return employeeDto;

		}
		throw new UserNotFoundException("invalid id");
	}

	@Override
	public EmployeeDto deleteEmployee(Long userId) {
		Optional<Employee> findById = employeeRepository.findById(userId);
		if (findById.isPresent()) {
			employeeRepository.deleteById(userId);
			return new EmployeeDto();

		}
		throw new UserNotFoundException("id not present");
	}

}
