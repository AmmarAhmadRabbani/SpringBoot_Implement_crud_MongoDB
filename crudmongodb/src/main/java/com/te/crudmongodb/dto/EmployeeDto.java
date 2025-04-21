package com.te.crudmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Long userId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String password;

}
