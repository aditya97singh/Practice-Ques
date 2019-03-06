package com.capgemini.service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.capgemini.beans.Customer;
import com.capgemini.beans.WalletC;
import com.capgemini.exceptions.*;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.repo.CustomerRepoImpl;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerRepo crepo;
    public  CustomerServiceImpl(){
		crepo=new CustomerRepoImpl();;
	}
	
	public Customer createAccount(String name, String mobNo,BigDecimal am) throws DuplicateMobileNoException, MobileNoIsNotFoundException, InsufficientAmountException
	{
	
		if(crepo.findOne(mobNo)==null)
		{
		WalletC w=new WalletC();
        Customer c=new Customer();
		c.setName(name);
		c.setMobNo(mobNo);
		w.setBalance(am);
		c.setWallet(w);
		if(crepo.save(c))
		{ 
			     return c;
		}
	    }throw new DuplicateMobileNoException();
	}
	
	public Customer showAmount(String mobNo) throws MobileNoIsNotFoundException, InsufficientAmountException
	{
		if(crepo.findOne(mobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		return crepo.findOne(mobNo);
	}
	
	public Customer depositAmount(String mobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException
	{
		if(crepo.findOne(mobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		Customer c=crepo.findOne(mobNo);
		if(c!=null)
		{	
		 
		 WalletC w=new WalletC();
		 w.setBalance(am.add(c.getWallet().getBalance()));
		 c.setWallet(w);
		 BigDecimal u=c.getWallet().getBalance();
		 crepo.update(mobNo, u);
		 return c;
		} 
		return null;
	}
	
	public Customer withdrawAmount(String mobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException
	{
		if(crepo.findOne(mobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		
		Customer c=crepo.findOne(mobNo);
		if(c!=null)
		{	
			BigDecimal a = c.getWallet().getBalance();
			int i = a.compareTo(am);
			if(i == -1) {
				throw new InsufficientAmountException();
			}
		 WalletC w=new WalletC();
		 w.setBalance((c.getWallet().getBalance()).subtract(am));
		 c.setWallet(w);
		 BigDecimal u=c.getWallet().getBalance();
		 crepo.update(mobNo, u);
		 return c;
		}
		return null;
	}
	
	public Customer fundTransfer(String sourceMobNo, String targetMobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException 
	{
		Customer a=crepo.findOne(sourceMobNo);
		Customer b=crepo.findOne(targetMobNo);
		
		if(crepo.findOne(targetMobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		if(a!=null && b!=null)
		{
			BigDecimal y = a.getWallet().getBalance();
			int i = y.compareTo(am);
			if(i <0) {
				throw new InsufficientAmountException();
			}
			
			WalletC w1=new WalletC();
			WalletC w2=new WalletC();
			w1.setBalance(am.add(b.getWallet().getBalance()));
			w2.setBalance((a.getWallet().getBalance()).subtract(am));
			a.setWallet(w2);
			b.setWallet(w1);
			BigDecimal s=a.getWallet().getBalance();
			BigDecimal t=b.getWallet().getBalance();
			crepo.update(sourceMobNo,s);
			crepo.update(targetMobNo,t);
			return b;
		}
		return null;
	}
	
	@Override
	public boolean validateName(String name) throws InvalidInputException
	{
		if(name==null)
			throw new InvalidInputException();
		Pattern p=Pattern.compile("[Aza-z]{1,20}");
		Matcher m=p.matcher(name);
		if(!(m.matches()))
			throw new InvalidInputException();	
		return m.matches();	
	}
	
	@Override
	public boolean validateMobileNumber(String mobno) throws InvalidInputException
	{
		if(mobno==null)
			throw new InvalidInputException();
		Pattern p=Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher m=p.matcher(mobno);
		if(!(m.matches()))
			throw new InvalidInputException();	
		return m.matches();	
	}
	
	@Override
	public boolean validateBalance(BigDecimal balance) throws InvalidInputException
	{
		if(balance==null)
			throw new InvalidInputException();
		Pattern p=Pattern.compile("[1-9]{1}[0-9]{1,5}");
		Matcher m=p.matcher(String.valueOf(balance));
		if(!(m.matches()))
			throw new InvalidInputException();	
		return m.matches();	
	}
}
