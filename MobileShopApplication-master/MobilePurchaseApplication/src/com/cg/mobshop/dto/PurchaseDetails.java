package com.cg.mobshop.dto;

import java.util.Date;

public class PurchaseDetails {
	private int purchaseId;
	private int mobileId;
	private String custName;
	private String mailId;
	private String phoneNo;
	private Date purchaseData;
	
	
	public int getPurchaseId() {
		return purchaseId;
	}
	
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	public int getMobileId() {
		return mobileId;
	}
	
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getMailId() {
		return mailId;
	}
	
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getPurchaseData() {
		return purchaseData;
	}

	public void setPurchaseData(Date purchaseData) {
		this.purchaseData = purchaseData;
	}

}
