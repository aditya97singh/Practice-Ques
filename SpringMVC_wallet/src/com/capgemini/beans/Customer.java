package com.capgemini.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	private String name;
	@Id
	private String mobNo;
	@Embedded
	private WalletC wallet; 
	
	public Customer(String name, String mobNo,WalletC wallet) {
		super();
		this.name = name;
		this.mobNo = mobNo;
		this.wallet=wallet;
	} 
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public WalletC getWallet() {
		return wallet;
	}
	public void setWallet(WalletC wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobNo=" + mobNo + ", wallet=" + wallet + "]";
	}
	
	
	
}
