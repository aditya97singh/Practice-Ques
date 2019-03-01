package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.dao.ISaleDAO;
import com.capgemini.salesmanagement.exception.ValidateProductCategoryException;
import com.capgemini.salesmanagement.exception.ValidateProductIdException;
import com.capgemini.salesmanagement.exception.ValidateProductNameException;
import com.capgemini.salesmanagement.exception.ValidateProductPriceException;
import com.capgemini.salesmanagement.exception.ValidateProductQuantityException;

public class SaleService implements ISaleService {
	private ISaleDAO saledao;
	

	public SaleService(ISaleDAO saledao) {
		super();
		this.saledao = saledao;
	}

	@Override
	public HashMap<Integer, Sale> insertSalesDetails(Sale sale) {
		
		return saledao.insertSalesDetails(sale);
		
	}

	@Override
	public boolean validateProductCode(int productId) throws ValidateProductIdException {
		if (productId == 1001 || productId == 1002 || productId == 1003
				|| productId == 1004)
			return true;
		else
			throw new ValidateProductIdException("Enter Valid Product Code");
	}

	@Override
	public boolean validateQuantity(int qty) throws ValidateProductQuantityException {
		if (qty > 0 && qty < 5)
			return true;
		else
			throw new ValidateProductQuantityException("Enter valid Produce Quantity");
	}

	@Override
	public boolean validateProductCat(String prodCat) throws ValidateProductCategoryException {
		if (prodCat.equals("Electronics") || prodCat.equals("Toys"))
			return true;
		else
			throw new ValidateProductCategoryException("Enter valid Product Category");
	}

	@Override
	public boolean validateProductName(String prodName) throws ValidateProductNameException {
		if (prodName.equals("TV") || prodName.equals("Smart Phone")
				|| prodName.equals("Video Game"))
			return true;
		else if (prodName.equals("Barbee Doll") || prodName.equals("Soft Toys")
				|| prodName.equals("Telescope"))
			return true;
		else
			throw new ValidateProductNameException("Enter valid product name");
	}

	@Override
	public boolean validateProductPrice(float price) throws ValidateProductPriceException {
		if (price > 200f)
			return true;
		else
			throw new ValidateProductPriceException("Enter the valid price");
	}

}
