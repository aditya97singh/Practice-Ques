package com.capgemini.takehome.bean;

public class Product {
	/*--------PRODUCT PROPERTIES----------*/
	private int productId;
	private String productName;
	private String productCategory;
	private int productPrice;
	private int productQuantity;
	private int lineTotal;

	/*-------------DEFAULT CONSTRUCTOR-------------*/
	public Product() {
		super();
	}

	/*------------- CONSTRUCTOR-------------*/

	public Product(int productId, String productName, String productCategory, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}

	/*------------- GETTERS AND SETTERS-------------*/

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(int lineTotal) {
		this.lineTotal = lineTotal;
	}

	/*----------RETURN TO STRING VALUES-----------------*/
	@Override
	public String toString() {
		return "Product Name: " + productName + "\nProduct Category: " + productCategory + "\nProduct Price (Rs): "
				+ productPrice + "\nQuantity: " + productQuantity + "\nLine Total(Rs): " + lineTotal + "\n";

	}
}
