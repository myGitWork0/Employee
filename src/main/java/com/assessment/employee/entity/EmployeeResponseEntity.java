package com.assessment.employee.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@JsonPropertyOrder({ "message", "data" })
public class EmployeeResponseEntity {

	@JsonProperty("message")
	private String message = "Success";
	@JsonProperty("data")
	private Object data;
}

