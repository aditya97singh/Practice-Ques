package com.capgemini.salesmanagement.exception;

public class ValidateProductQuantityException extends Exception {

	@Override
	public String toString() {
		return "ValidateProductQuantityException []";
	}
	
	public ValidateProductQuantityException(String msg){
		super(msg);
	}

}
