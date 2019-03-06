package com.capgemini.repo;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.capgemini.beans.Customer;


@Repository("walletrepo")
public class CustomerRepoImpl implements CustomerRepo {
	
	@PersistenceContext
	EntityManager manager;
	

	@Override
	public boolean save(Customer customer) { 
		
		if(customer!=null){
		manager.persist(customer);				
		manager.flush();		
		return true;							
		}
		
		return false;							
	
	}
	@Override
	public Customer findOne(String mobileNo) { 						
		
		
		Customer custSearch=manager.find(Customer.class, mobileNo); 
	
		return custSearch;											
		
	}
	@Override
	public void update(String mobileNo, BigDecimal amount){
	
		//em.getTransaction().begin();
        //Customer c=new Customer();  
        //WalletC w=new WalletC();
        Customer c=manager.find(Customer.class,mobileNo);
        c.getWallet().setBalance(amount);
        // em.getTransaction().commit();
        //em.close();
		
	}


	
}
