package com.capgemini.repo;

import java.math.BigDecimal;
import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientAmountException;
import com.capgemini.exceptions.MobileNoIsNotFoundException;

public interface CustomerRepo {
	
	public boolean save(Customer customer);
	public Customer findOne(String mobNo) throws MobileNoIsNotFoundException, InsufficientAmountException;
	void update(String mobileNo, BigDecimal amount) throws MobileNoIsNotFoundException, InsufficientAmountException;
}
