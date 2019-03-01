package com.capgemini.salesmanagement.exception;

public class ValidateProductIdException extends Exception {

	@Override
	public String toString() {
		return "ValidateProductIdException";
	}
	public ValidateProductIdException(String msg){
		super(msg);
	}
	

}
