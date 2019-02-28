package com.capgemini.view;

import java.util.Scanner;
import com.capgemini.service.*;
import java.time.LocalDate;
import com.capgemini.beans.*;
import com.capgemini.exceptions.InvalidCourseNameException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.exceptions.InvalidRatingException;

public class MainApp {

	public static void main(String[] args) throws InvalidCourseNameException, InvalidNameException, InvalidRatingException {

		FeedbackService fs = new FeedbackServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("*******Feedback of Trainer*******\n");
			System.out.println(" 1.   Add Trainer Feedback");
			System.out.println(" 2.   Display Details");
			System.out.println(" 3.   Exit");

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
                if(fs.validateName(name) && fs.validateCourseName(cname) && fs.validateRating(r) )
				{
                	fs.addFeedback(t);
				    System.out.println("Welcome :" + name + ", Your deatils are added");
				}
				break;

			case 2:
				System.out.println("Details : " + fs.getTrainerList());
				break;
			}
		} while (ch != 3);
	}
}
