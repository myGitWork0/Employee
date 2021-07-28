package com.assessment.employee.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.employee.entity.Employee;
import com.assessment.employee.entity.EmployeeResponseEntity;
import com.assessment.employee.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	  @Autowired
	  private EmployeeRepository employeeRepository;
	  
	  @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<EmployeeResponseEntity> getEmployeeById(@PathVariable String employeeId) {
		  EmployeeResponseEntity response = new EmployeeResponseEntity();
		  	try {
				Optional<Employee> employeeInfo = employeeRepository.findById(employeeId);
				response.setData(employeeInfo.get());
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				response.setMessage(e.getMessage());
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	  
	  @PostMapping("/")
	  public ResponseEntity<EmployeeResponseEntity> addEmployee(@RequestBody Employee employee) {
		EmployeeResponseEntity response = new EmployeeResponseEntity();
		try {
		   Employee savedEmployee = employeeRepository.save(employee);
		   response.setData(savedEmployee);
		   return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	  @PutMapping("/{employeeId}")
	  public ResponseEntity<EmployeeResponseEntity> updateEmployee(@RequestBody Employee employee, @PathVariable String employeeId) {
		  
		  EmployeeResponseEntity response = new EmployeeResponseEntity();
		  	try {
		  		Employee employeeFromDb = employeeRepository.findById(employeeId).get();
		  		BeanUtils.copyProperties(employee, employeeFromDb);
		  		response.setData(employeeRepository.save(employeeFromDb));
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				response.setMessage(e.getMessage());
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	      
	  }
	  
}
