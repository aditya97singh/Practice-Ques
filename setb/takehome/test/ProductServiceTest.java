package com.capgemini.takehome.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.takehome.exception.InvalidProductIdException;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;

public class ProductServiceTest {

	IProductService productService = new ProductService();

	// when product code is not available throw exception
	@Test(expected = InvalidProductIdException.class)
	public void whenProductCodeIsNotAvailableThrowException() throws InvalidProductIdException {
		productService.getProductDetails(1005);
	}

	// when valid info is passed show info to client
	@Test
	public void whenValifInfoIsPassedShowInfoToClient() throws InvalidProductIdException {
		productService.getProductDetails(1001);

	}

}
