package com.capgemini.service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidInputException;
import com.capgemini.repo.WalletRepo;
import com.capgemini.repo.WalletRepoImplementation;

public class WalletServiceImplementation implements WalletService{
	WalletRepo walletrepo;

	
	
	public WalletServiceImplementation(WalletRepo walletrepo) {
		super();
		this.walletrepo = walletrepo;
	}

	
	public WalletServiceImplementation() {
		walletrepo=new WalletRepoImplementation();
	}
	
	
	
	@Override
	public Customer createAccount(String cName, String mobileNumber,BigDecimal balance) throws DuplicateMobileNumberException{
		
		if(walletrepo.findOne(mobileNumber)!=null)
			throw new DuplicateMobileNumberException("Entered Mobile Number already exists");
		Wallet wallet=new Wallet(balance);
		Customer c=new Customer(cName, mobileNumber, wallet);
		if(walletrepo.save(c)){
			return c;
		}
			return null;
			
	
		
	}

	@Override
	public Customer showBalance(String mobileNumber) throws InvalidInputException {
		
		Customer customer=walletrepo.findOne(mobileNumber);
		if(customer==null)
			throw new InvalidInputException("Number not registered");
		else
		return customer;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber,BigDecimal balance) throws InvalidInputException {
		
		Customer customer1=walletrepo.findOne(sourceMobileNumber);
		if(customer1==null)
			throw new InvalidInputException("Number not registered");
		
		Wallet wallet1=customer1.getWallet();
		BigDecimal currentBalance=wallet1.getBalance();
		Customer customer2=walletrepo.findOne(targetMobileNumber);
		if(customer2==null)
			throw new InvalidInputException("Number not registered");
		
		Wallet wallet2=customer2.getWallet();
		BigDecimal currentBalance2=wallet2.getBalance();
		
		if(currentBalance.compareTo(balance)<0)
			throw new InvalidInputException("Your account balance is less than amount you are transferring");
		
		currentBalance2= currentBalance2.add(balance);
		currentBalance= currentBalance.subtract(balance);
		wallet1.setBalance(currentBalance);
		customer1.setWallet(wallet1);
		walletrepo.save(customer1);
		
		wallet2.setBalance(currentBalance2);
		customer2.setWallet(wallet2);
		walletrepo.save(customer2);
		
		
		Customer customer3=walletrepo.findOne(sourceMobileNumber);
		
		return customer3;
	}

	@Override
	public Customer deposit(String mobileNumber, BigDecimal amount) throws InvalidInputException {
		
		Customer customer=walletrepo.findOne(mobileNumber);
		if(customer==null)
			throw new InvalidInputException("Entered Mobile Number is not registered");
		Wallet wallet=customer.getWallet();
		BigDecimal currentbal=wallet.getBalance();
		
		BigDecimal newbal= currentbal.add(amount);
		wallet.setBalance(newbal);
		customer.setWallet(wallet);
		walletrepo.save(customer);
		
		Customer customer1=walletrepo.findOne(mobileNumber);
		
		return customer1;
	}

	@Override
	public Customer withdraw(String mobileNumber, BigDecimal balance) throws InsufficientBalanceException, InvalidInputException {
		Customer customer=walletrepo.findOne(mobileNumber);
		if(customer==null)
			throw new InvalidInputException("Entered Mobile Number is not registered");
		
		Wallet wallet=customer.getWallet();
		BigDecimal currentbal=wallet.getBalance();
		if(currentbal.compareTo(balance)>0){
			BigDecimal newBalance= currentbal.subtract(balance);
			wallet.setBalance(newBalance);
			customer.setWallet(wallet);
			walletrepo.save(customer);
		
			Customer customer1=walletrepo.findOne(mobileNumber);
		
		return customer1;
		}
		else
			throw new InsufficientBalanceException("Current balance is lesser than the amount you want to withdraw ");
	}

	@Override
	public boolean ValidateName(String cName) throws InvalidInputException {
		if(cName==null)
			throw new InvalidInputException("Name field cannot be empty");
		Pattern pattern=Pattern.compile("[A-Za-z ]{1,20}");
		Matcher mat=pattern.matcher(cName);
		if(mat.matches())
			return mat.matches();
		throw new InvalidInputException("Enter valid name");
	}

	@Override
	public boolean ValidateMobNo(String mobileNumber) throws InvalidInputException {
		if(mobileNumber==null)
			throw new InvalidInputException("Mobile Number cannot be zero");
		Pattern pattern=Pattern.compile("[6-9][0-9]{9}");
		Matcher mat=pattern.matcher(mobileNumber);
		if(mat.matches())
			return mat.matches();
		throw new InvalidInputException("Enter valid mobile number");
	}

	@Override
	public boolean ValidateAmount(BigDecimal balance) throws InvalidInputException {
		
		if(balance==null)
		throw new InvalidInputException("Amount must be greater than zero");
	Pattern pattern=Pattern.compile("[0-9]+.?[0-9]*");
	Matcher mat=pattern.matcher(String.valueOf(balance));
	if(mat.matches())
		return mat.matches();
	throw new InvalidInputException("Enter valid amount");
	}
}
