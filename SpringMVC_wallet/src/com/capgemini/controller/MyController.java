package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.DuplicateMobileNoException;
import com.capgemini.exceptions.InsufficientAmountException;
import com.capgemini.exceptions.MobileNoIsNotFoundException;
import com.capgemini.service.CustomerService;


@Controller
public class MyController {
	
	@Autowired
	CustomerService customerser;
	
	
	@RequestMapping(value="menu")
	public String menu(){
		
		System.out.println("Redirecting to menu page...");
		return "menu";
	}
	
	@RequestMapping(value="addacc")
	public String addAccount(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to create account page......");
		return "createacc" ;
		
	}
	@RequestMapping(value="createaccsuccess",method=RequestMethod.POST)
	public String successone(@ModelAttribute("my") Customer cust){
		
		System.out.println(cust);
		try {
			 customerser.createAccount(cust.getMobNo(), cust.getName(), cust.getWallet().getBalance());
			
		} catch (MobileNoIsNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		catch (DuplicateMobileNoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("Account Created....");
		return "createaccsuccess";
	}
	
	@RequestMapping(value="showbal")
	public String showBalance(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to show balance page......");
		return "showbalance" ;
	
	}
	@RequestMapping(value="showbalancesuccess")
	public ModelAndView showBalanceSuccess(@ModelAttribute("my") Customer cust){
		Customer c=null;
		System.out.println("Redirecting to  balance display page......");
		try {
			 c=customerser.showAmount(cust.getMobNo());
			System.out.println(c.getWallet().getBalance());
		} catch (MobileNoIsNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("showbalancesuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="deposit")
	public String deposit(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to deposit money page......");
		return "deposit" ;
	}
	
	@RequestMapping(value="depositsuccess")
	public ModelAndView depositSuccess(@ModelAttribute("my") Customer cust){
		Customer c=null;
		System.out.println("Redirecting to  deposit success page......");
		try {
			 c=customerser.depositAmount(cust.getMobNo(), cust.getWallet().getBalance());
			System.out.println(c);
		} catch (MobileNoIsNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("depositsuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="withdraw")
	public String withdraw(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to withdraw(enter mobile no)  page......");
		return "withdraw" ;
	}
	@RequestMapping(value="withdraw2")
	public ModelAndView withdraw2(@ModelAttribute("my") Customer cust){
		System.out.println("Redirecting to withdraw(enter money) page......");
		Customer c=null;
		try {
			 c=customerser.showAmount(cust.getMobNo());
			System.out.println(c);
		}catch (MobileNoIsNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("withdraw2", "data", c) ;
	}
	
	@RequestMapping(value="withdrawsuccess",method=RequestMethod.POST)
	public ModelAndView withdrawSuccess(@ModelAttribute("my") Customer cust,@RequestParam("mNo") String s ){
		Customer c=null;
		System.out.println("Redirecting to  withdraw success page......");
		System.out.println(cust.getMobNo()+"     "+   cust.getWallet().getBalance());
		System.out.println(s);
		
			 try {
				c=customerser.withdrawAmount(s, cust.getWallet().getBalance());
			} catch (InsufficientAmountException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			 catch (MobileNoIsNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			System.out.println(c);
	
		
		return new ModelAndView("withdrawsuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="fundtransf")
	public String fundtransf(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to fundtransfer(enter mobile no)  page......");
		return "fundtransf" ;
	}
	@RequestMapping(value="fundtransf2")
	public ModelAndView fundtransf2(@ModelAttribute("my") Customer cust){
		System.out.println("Redirecting to fundtransf(enter money) page......");
		Customer c=null;
		try {
			 c=customerser.showAmount(cust.getMobNo());
			System.out.println(c);
		} catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 catch (MobileNoIsNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		return new ModelAndView("fundtransf2", "data", c) ;
	}
	
	@RequestMapping(value="fundtransfsuccess",method=RequestMethod.POST)
	public ModelAndView fundtransfSuccess(@ModelAttribute("my") Customer cust,@RequestParam("amount") String s ){
		Customer c=null;
		System.out.println("Redirecting to  fundtransf success page......");
		System.out.println(cust.getMobNo()+"     "+   cust.getWallet().getBalance());
		System.out.println(s);
		
		try {
			 c=customerser.fundTransfer(s, cust.getMobNo(), cust.getWallet().getBalance());
			System.out.println(c);
		}catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 catch (MobileNoIsNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		return new ModelAndView("fundtransfsuccess", "data", c) ;
	
	}
	
	
	
}
	
	
	
	
	
	
	
	

