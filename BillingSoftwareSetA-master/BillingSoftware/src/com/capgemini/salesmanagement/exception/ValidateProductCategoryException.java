package com.capgemini.salesmanagement.exception;

public class ValidateProductCategoryException extends Exception {

	@Override
	public String toString() {
		return "ValidateProductCategoryException";
	}
	
	public ValidateProductCategoryException(String msg){
		super(msg);
		
	}

}
