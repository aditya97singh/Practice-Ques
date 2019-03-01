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
			System.out.println("////////////// Feedback of Trainer \\\\\\\\\\\\\\\\\\");
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
				String coursename = sc.next();
				System.out.println("Please Enter Start Date as day,month then year");
				int startday = sc.nextInt();
				int startmonth = sc.nextInt();
				int startyear = sc.nextInt();
				System.out.println("Please Enter End Date as day,month then year");
				int endday = sc.nextInt();
				int endmonth = sc.nextInt();
				int endyear = sc.nextInt();
				System.out.println("Enter Rating");
				int rate = sc.nextInt();

				Trainer t = new Trainer(name, coursename, LocalDate.of(startyear, startmonth, startday), LocalDate.of(endyear, endmonth, endday), rate);
                if(fs.validateName(name) && fs.validateCourseName(coursename) && fs.validateRating(rate) )
				{
				    System.out.println("Welcome " + fs.addFeedback(t) + ", Your deatils are added");
				}
				break;

			case 2:
				System.out.println("Enter the rating :");
				int rating = sc.nextInt();
				System.out.println("Details : " + fs.getTrainerList(rating));
				break;
			}
		} while (ch != 3);
	}
}
