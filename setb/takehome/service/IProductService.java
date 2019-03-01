package com.capgemini.takehome.service;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exception.InvalidProductIdException;

public interface IProductService {

	Product getProductDetails(int productCode) throws InvalidProductIdException;

	boolean validateProductCode(Double productCode);

}
