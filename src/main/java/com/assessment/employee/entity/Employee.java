package com.assessment.employee.entity;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
	@Id
	private String id;

	private String firstName;
	private String lastName;
	private int salary;

	public Employee() {}

	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("Employee[id=%s, firstName='%s', lastName='%s', salary='%s']", id, firstName, lastName, salary);
	}
}