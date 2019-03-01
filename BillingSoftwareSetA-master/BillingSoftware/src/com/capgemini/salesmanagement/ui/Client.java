package com.capgemini.salesmanagement.ui;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.dao.ISaleDAO;
import com.capgemini.salesmanagement.dao.SaleDAO;
import com.capgemini.salesmanagement.exception.ValidateProductCategoryException;
import com.capgemini.salesmanagement.exception.ValidateProductIdException;
import com.capgemini.salesmanagement.exception.ValidateProductNameException;
import com.capgemini.salesmanagement.exception.ValidateProductPriceException;
import com.capgemini.salesmanagement.exception.ValidateProductQuantityException;
import com.capgemini.salesmanagement.service.ISaleService;
import com.capgemini.salesmanagement.service.SaleService;

public class Client {
	private static ISaleDAO saledao = new SaleDAO();
	private static ISaleService saleservice = new SaleService(saledao);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ValidateProductIdException, ValidateProductQuantityException, ValidateProductCategoryException, ValidateProductNameException, ValidateProductPriceException {

		showMenu();
	}

	private static void showMenu() {
		int ch;
		while (true) {
			System.out.println("1. Insert Details and generate bills");
			System.out.println("2. exit");
			System.out.println("Enter the choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				try {
					insertSalesDetails();
				} catch (ValidateProductIdException e) {
					
					System.out.println(e.getMessage());
				} catch (ValidateProductQuantityException e) {
					
					System.out.println(e.getMessage());
				} catch (ValidateProductCategoryException e) {
					
					System.out.println(e.getMessage());
				} catch (ValidateProductNameException e) {
					
					System.out.println(e.getMessage());
				} catch (ValidateProductPriceException e) {
					
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.exit(0);
				break;
			}
		}

	}

	private static void insertSalesDetails() throws ValidateProductIdException, ValidateProductQuantityException, ValidateProductCategoryException, ValidateProductNameException, ValidateProductPriceException {
		int pc;
		do {

			System.out.print("Enter Product Code");
			pc = sc.nextInt();
		} while (!saleservice.validateProductCode(pc));
		int q;
		do {
			System.out.println("Enter the quantity");
			q = sc.nextInt();
		} while (!saleservice.validateQuantity(q));
		String proCat;
		do {
			System.out.println("Enter the product Category");
			proCat = sc.next();
		} while (!saleservice.validateProductCat(proCat));
		String proName;
		sc.nextLine();
		do {
			System.out.println("Enter the product name");
			proName = sc.nextLine();
		} while (!saleservice.validateProductName(proName));
		float p;
		do {
			System.out.println("Enter the price");
			p = sc.nextFloat();
			sc.nextLine();
		} while (!saleservice.validateProductPrice(p));

		int saleId = (int) (Math.random() * 1000);
		float lineTotal = q * p;
		Sale sale = new Sale(saleId, pc, proName, proCat, LocalDate.now(), q,
				p, lineTotal);
		HashMap<Integer, Sale> hashMap = saleservice.insertSalesDetails(sale);
		Sale s = hashMap.get(saleId);
		System.out.println(s.getQuantity());
		System.out.println(s.getLineTotal());
		for(Map.Entry<Integer, Sale> e: hashMap.entrySet()){
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}

	}

}
