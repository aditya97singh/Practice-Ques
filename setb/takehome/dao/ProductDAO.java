package com.capgemini.takehome.dao;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exception.InvalidProductIdException;
import com.capgemini.takehome.util.CollectionUtil;

public class ProductDAO implements IProductDAO {

	Product product;
	CollectionUtil collectionUtil;

	@Override
	public Product getProductDetails(int productCode) throws InvalidProductIdException {
		product = CollectionUtil.getProducts().get(productCode);
		if (product == null) {
			throw new InvalidProductIdException("Sorry! The Product Code " + productCode + " is not available.");
		}
		product.setLineTotal(product.getProductPrice() * product.getProductQuantity());
		return product;

	}

}
