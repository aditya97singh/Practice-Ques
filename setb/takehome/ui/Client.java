package com.capgemini.takehome.ui;

import java.util.Scanner;
import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exception.InvalidProductIdException;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;

public class Client {

	static Scanner scanner = new Scanner(System.in);
	static IProductService productService = new ProductService();

	public static void main(String[] args) throws Exception {

		showMenu();
	}

	/*------------SHOW MENU-----------*/
	private static void showMenu() throws InvalidProductIdException {
		int choice = 0;
		do {

			System.out.println("1. Generate Bill by entering Product code and quantity");
			System.out.println("2. Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				generateBillByProductCodeandQuantity();
				break;
			case 2:
				System.exit(0);
				break;
			default:
				System.out.println("You've Entered wrong choice!");
			}
		} while (choice != 2);

	}

	/*------------GENERATE BILL BY PRODUCTCODE AND QUANTITY-----------*/

	private static void generateBillByProductCodeandQuantity() throws InvalidProductIdException {

		System.out.println("Enter the Product Code: ");
		int productCode = scanner.nextInt();
		System.out.println("Enter the quantity: ");
		int quantity = scanner.nextInt();
		Product product = new Product();

		/*-----QUANTITY VALIDATION----------*/
		if (quantity > 0) {
			product.setProductQuantity(quantity);

		} else {
			System.out.println("Product Quantity Can't be Less than or equal to zero!");
		}

		/*--------PASSING PRODUCT CODE TO GET DETAILS-------------*/
		product = productService.getProductDetails(productCode);
		System.out.println(product);

	}

}
