package com.te.crudmongodb.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {
	private boolean error;
	private String message;
	private Object data;

}
