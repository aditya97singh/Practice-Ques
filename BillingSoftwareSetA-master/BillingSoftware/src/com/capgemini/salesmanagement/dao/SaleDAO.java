package com.capgemini.salesmanagement.dao;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.util.CollectionUtil;

public class SaleDAO implements ISaleDAO {

	@Override
	public HashMap<Integer, Sale> insertSalesDetails(Sale sale) {
	HashMap<Integer,Sale> hmap = CollectionUtil.getCollection();
	hmap.put(sale.getSaleId(), sale);
	return hmap;
	}

}
