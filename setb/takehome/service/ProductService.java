package com.capgemini.takehome.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exception.InvalidProductIdException;

public class ProductService implements IProductService {

	IProductDAO productDao= new ProductDAO();
	
	/*-----------GET PRODUCT DETAILS------------------*/
	@Override
	public Product getProductDetails(int productCode) throws InvalidProductIdException {
		
		return productDao.getProductDetails(productCode);
	}

	/*---------PRODUCT CODE VALIDATION----------*/
	@Override
	public boolean validateProductCode(Double productCode) {
		String proCode = productCode.toString();
		Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{3}");
		Matcher matcher = pattern.matcher(proCode);
		return matcher.matches();
	}
	

}
