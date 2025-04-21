package com.te.crudmongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
//	@Transient
//	public static final String SEQUENCE_NAME = "employee_sequence";

	private Long userId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String password;

}
