package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.exception.ValidateProductCategoryException;
import com.capgemini.salesmanagement.exception.ValidateProductIdException;
import com.capgemini.salesmanagement.exception.ValidateProductNameException;
import com.capgemini.salesmanagement.exception.ValidateProductPriceException;
import com.capgemini.salesmanagement.exception.ValidateProductQuantityException;

public interface ISaleService {
	public HashMap<Integer, Sale> insertSalesDetails(Sale sale);
	public boolean validateProductCode(int productId) throws ValidateProductIdException;
	public boolean validateQuantity(int qty) throws ValidateProductQuantityException;
	public boolean validateProductCat(String prodCat) throws ValidateProductCategoryException;
	public boolean validateProductName(String prodName) throws ValidateProductNameException;
	public boolean validateProductPrice(float price) throws ValidateProductPriceException;

}
