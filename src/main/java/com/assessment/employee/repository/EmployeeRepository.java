package com.assessment.employee.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assessment.employee.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public List<Employee>  findByFirstName(String firstName);

}
