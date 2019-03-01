package com.capgemini.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bean.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidInputException;
import com.capgemini.repo.WalletRepo;
import com.capgemini.repo.WalletRepoImplementation;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImplementation;

public class WalletTesting {
	WalletRepo wrepo;
	WalletService wService;

	@Before
	public void setUp() throws Exception {
	wrepo = new WalletRepoImplementation();
	wService = new WalletServiceImplementation(wrepo);
		
	}
	
	
	@Test(expected = com.capgemini.exception.DuplicateMobileNumberException.class)
	public void whenTheMobileNumberYouEnteredIsAlreadyExist()throws DuplicateMobileNumberException {
		wService.createAccount("Shobhit", "9450766173", BigDecimal.valueOf(2000));
		
	}
	
	@Test(expected = com.capgemini.exception.InsufficientBalanceException.class)
	public void whenTheAmountYorAreWithdrawingIsGreaterThanTheCurrentAmount()throws InsufficientBalanceException, InvalidInputException {
		wService.withdraw("9450766173",BigDecimal.valueOf(4500));
		
	}
	
	
	@Test(expected=com.capgemini.exception.InvalidInputException.class)
	public void whenMobileNumberYouEnteredForShowBalanceIsNotPresentInTheDatabaseThenSystemShouldThrowAnException() throws InvalidInputException {
		wService.showBalance("9208574810");
	}
	
	@Test
	public void whenCustomerInformationIsCorrectThenSystemShouldShowTheBalance() throws InvalidInputException {
		wService.showBalance("9731803567");
	}

	
	@Test
	public void whenCustomerInformationIsCorrectThenSystemShouldTransferFundFromOneAccountToAnother() throws InvalidInputException, InsufficientBalanceException {
		wService.fundTransfer("9450766173", "9731803567", new BigDecimal("1000"));
	}
	
	
	@Test
	public void whenCustomerInformationIsCorrectThenSystemShouldDepositMoneyToAccount() throws InvalidInputException {
		wService.deposit("9731803567", new BigDecimal("200"));
	}
	
	
	@Test
	public void whenCustomerInformationIsCorrectThenSystemShouldWithdrawAmountFromAccount() throws InvalidInputException, InsufficientBalanceException {
		wService.withdraw("9731803567", new BigDecimal("100"));
	}
	
}
	

