package com.capgemini.salesmanagement.exception;

public class ValidateProductPriceException extends Exception {

	@Override
	public String toString() {
		return "ValidateProductPriceException []";
	}
	public ValidateProductPriceException(String msg){
		super(msg);
	}

}
