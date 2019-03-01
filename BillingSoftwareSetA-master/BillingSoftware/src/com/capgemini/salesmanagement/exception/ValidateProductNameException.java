package com.capgemini.salesmanagement.exception;

public class ValidateProductNameException extends Exception {

	@Override
	public String toString() {
		return "ValidateProductNameException";
	}
	
	public ValidateProductNameException(String msg){
		super(msg);
	}
	

}
