package com.capgemini.takehome.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.takehome.bean.Product;

public class CollectionUtil {
	private static Map<Integer, Product> products = new HashMap<>();
	/*-----------ITEMS IN HASH SET-----------*/
	static {
		getProducts().put(1001, new Product(1001, "iPhone", "Electronics", 35000));
		getProducts().put(1002, new Product(1002, "LEDTV", "Electronics", 45000));
		getProducts().put(1003, new Product(1003, "Teddy", "Toys", 800));
		getProducts().put(1004, new Product(1004, "Telescope", "Toys", 5000));

	}

	/*----GETTER----------*/
	public static Map<Integer, Product> getProducts() {
		return products;
	}

	/*----SETTER----------*/
	public static void setProducts(Map<Integer, Product> products) {
		CollectionUtil.products = products;
	}

}
