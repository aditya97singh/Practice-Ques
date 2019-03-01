package com.capgemini.main;

import java.util.Locale;
import java.util.Scanner;

import com.capgemini.beans.Patient;
import com.capgemini.repo.*;
import com.capgemini.service.PatientService;
import com.capgemini.service.PatientServiceImpl;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		PatientRepo r=new PateintRepoImpl();
		PatientService ps=new PatientServiceImpl(r);
		while(true)
		{
			System.out.println("enter choice 1 for add detail  and 2 for show detail:  and 3 for exit");
			int c=sc.nextInt();		
			
			
			switch(c)
			{
			case 1:
				System.out.println("enter:-- id name phoneno email gender appointementdate  age  probname");
				int id=sc.nextInt();
				String n=sc.next();
				String ph=sc.next();
				String email=sc.next();
				String g=sc.next();
				String appd=sc.next();
				int a=sc.nextInt();
				String pn=sc.next();
				
				Patient p=new Patient(id,n,ph,email,g,appd,a,pn);
				ps.addDoctorAppointmentDetail(p);
				break;
			case 2:
				System.out.println("enter appintement id");
				int id1=sc.nextInt();
				try
				{
				ps.getDoctorAppointementDetail(id1);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.exit(0);
				
				
			
			}
		}
		
	/*Patient p=new Patient(1,"akarsh","986353463","akk@gmail.com","M","07-02-2019",24,"Heart");
	Patient p1=new Patient(2,"rahul","986353463","akk@gmail.com","M","07-02-2019",24,"Heart");
	ps.addDoctorAppointmentDetail(p);
	ps.getDoctorAppointementDetail(1);
	
	ps.addDoctorAppointmentDetail(p1);
	ps.getDoctorAppointementDetail(2);*/
	}
	
}