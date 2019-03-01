package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.beans.Patient;
import com.capgemini.service.*;
public class MainApp {

	public static void main(String[] args) {
		
		PatientService ps = new PatientServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("//////////////Appointment App\\\\\\\\\\\\\\\\\\");
			System.out.println(" 1.   Take Appointment");
			System.out.println(" 2.   Display Appointment Details");
			System.out.println(" 3.   Exit");

			System.out.println("\nEnter Your Choice :\n");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println(" Enter Name");
				String name = sc.next();
				System.out.println(" Enter phone no.");
				String phonno=sc.next();
				System.out.println(" Enter email");
				String email=sc.next();
				System.out.println(" Enter Gender");
				String gender=sc.next();
				System.out.println(" Enter Appointment Date ");
				String appointmentdate=sc.next();
				System.out.println(" Enter age");
				int age=sc.nextInt();
				System.out.println(" Enter problem name ");
				String probname=sc.next();
   
				int i=(int)(Math.random()*1000);
				Patient patient=new Patient(i,name,phonno,email,gender,appointmentdate,age,probname);
				System.out.println("Appointment Id :"+ps.addDoctorAppointment(patient)+"Approved");
				break;
			
			case 2:
				System.out.println(" Enter Appointment Id");
				int aid=sc.nextInt();
				ps.getAppointmentDetails(aid);
				break;
	          }
			}while(ch!=3);
		}
}
