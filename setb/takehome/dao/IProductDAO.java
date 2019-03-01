package com.capgemini.takehome.dao;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exception.InvalidProductIdException;

public interface IProductDAO {

	Product getProductDetails(int productCode) throws InvalidProductIdException;

}
