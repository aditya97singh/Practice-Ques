package com.cg.mobshop.ui;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;
import com.cg.mobshop.service.PurchaseService;
import com.cg.mobshop.service.PurchaseServiceImpl;

public class Main {

		public static void main(String[] args) throws PurchaseException {
			// TODO Auto-generated method stub
			PurchaseService service = new PurchaseServiceImpl(); 
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
		
			int ch=0;
			do{
				System.out.println("Enter choice:\n 1. Add customer\n 2. Get Mobile List \n 3. Get Mobile list in range : \n 4. Update Mobile details \n 5.Exit");
				ch = sc.nextInt();
				switch(ch){
		
				case 1:
			
					System.out.println("Enter Customer Name : ");
					String name = sc.next();
					System.out.println("Enter Phone no : ");
					String phone = sc.next();
					System.out.println("Enter Mail id : ");
					String mail = sc.next();
					System.out.println("Enter mobile id : ");
					int mid = sc.nextInt();
		
					PurchaseDetails pi = new PurchaseDetails();
					pi.setCustName(name);
					pi.setMailId(mail);
					pi.setMobileId(mid);
					pi.setPhoneNo(phone);
					int pd = service.addPurchaseDetails(pi);
					System.out.println("Record added ... " + pd);
					break;
				
				case 2 : 
					ArrayList<Mobile> list = service.getMobileList();
					if(list.size() == 0)
						System.err.println("No Record Found ... ");
					else {
						for (Mobile mob : list)
						{
							System.out.println();
							System.out.print(mob.getMobileId() + " ");
							System.out.print(mob.getName() + " ");
							System.out.print(mob.getPrice() + " ");
							System.out.print(mob.getQuantity());
						}
					}
					System.out.println();
					break;
					
				case 3 : 
					int min;
					System.out.print(" Enter the min of range : ");
					min = sc.nextInt();
					System.out.println(" Enter the max of range : ");
					int max = sc.nextInt();
					
					ArrayList<Mobile> list1 = service.getMobileList(min, max);
					if(list1.size() == 0)
						System.out.println(" No Record Found ...");
					else 
					{
						for (Mobile mob : list1)
						{
							System.out.println();
							System.out.print(mob.getMobileId() + " ");
							System.out.print(mob.getName() + " ");
							System.out.print(mob.getPrice() + " ");
							System.out.print(mob.getQuantity());
						}
					}
					System.out.println();
					break;
					
				case 4 : 
					System.out.println(" Enter the mobile id : ");
					int mob = sc.nextInt();
					System.out.println(" Enter the price : ");
					double price = sc.nextDouble();
					System.out.println(" Enter the quantity : ");
					int quant = sc.nextInt();
					Mobile m = new Mobile();
					m.setMobileId(mob);
					m.setPrice(price);
					m.setQuantity(quant);
					Mobile p = service.updateMobileDetails(m);
					if(p != null)
						System.out.println("Record Updated Successfully ... ");
					
				}
		}while(ch != 5);
	}

}
