package com.capgemini.service;

import java.math.BigDecimal;
import com.capgemini.beans.Customer;
import com.capgemini.exceptions.*;

public interface CustomerService {

	public Customer createAccount(String name, String mobNo, BigDecimal am) throws DuplicateMobileNoException, MobileNoIsNotFoundException, InsufficientAmountException;
	public Customer showAmount(String mobNo) throws MobileNoIsNotFoundException, InsufficientAmountException;
	public Customer depositAmount(String mobNo, BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException;
	public Customer withdrawAmount(String mobno,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException;
	public Customer fundTransfer(String sourceMobNo, String targetMobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException;
	boolean validateName(String name) throws InvalidInputException;
	boolean validateMobileNumber(String mobno) throws InvalidInputException;
	boolean validateBalance(BigDecimal balance) throws InvalidInputException;
}
