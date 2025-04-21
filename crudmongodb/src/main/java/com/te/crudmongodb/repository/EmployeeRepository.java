package com.te.crudmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.te.crudmongodb.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
