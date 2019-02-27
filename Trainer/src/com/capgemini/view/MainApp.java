package com.capgemini.view;

import java.math.BigDecimal;
import java.util.Scanner;
import com.capgemini.service.*;
import java.time.LocalDate;
import com.capgemini.beans.*;

public class MainApp {

	public static void main(String[] args) {

		FeedbackService fs = new FeedbackServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("*******Feedback of Trainer*******\n");
			System.out.println(" 1.   Add Trainer");
			System.out.println(" 2.   Display Details ");

			System.out.println("\nEnter Your Choice :\n");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Please Enter Name");
				String name = sc.next();
				System.out.println("Please Enter Course Name");
				String cname = sc.next();
				System.out.println("Please Enter Start Date");
				int sd = sc.nextInt();
				int sm = sc.nextInt();
				int sy = sc.nextInt();
				System.out.println("Please Enter End Date");
				int ed = sc.nextInt();
				int em = sc.nextInt();
				int ey = sc.nextInt();
				System.out.println("Enter Rating");
				int r = sc.nextInt();

				Trainer t = new Trainer(name, cname, LocalDate.of(sy, sm, sd), LocalDate.of(ey, em, ed), r);

				System.out.println("Account Created : " + fs.addFeedback(t));
				System.out.println("Welcome :" + name + ", Your Account is created");

				break;

			case 2:
				System.out.println("Details : " + fs.getTrainerList());

				break;
			}
		} while (ch != 3);
	}
}
