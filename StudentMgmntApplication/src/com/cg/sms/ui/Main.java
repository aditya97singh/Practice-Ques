package com.cg.sms.ui;

import java.util.Scanner;
import java.util.*;

import com.cg.sms.dto.Student;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//Student student=new Student();
		StudentService service=new StudentServiceImpl();
		int ch=0;
		
		
		Scanner sc=new Scanner(System.in);
		do{
		System.out.println("_________________________________________\n1.Add Student\n2.Display Student Details\n3.Update Details\n4.Display StudentList of same couse\n5.Exit\n\nEnter your choice --\n");
		ch=sc.nextInt();
		switch(ch){
		
		case 1 :
		
		
		System.out.println("Enter Name : ");
		String name=sc.next();
		
		System.out.println("Enter Course Name : ");
		String cname=sc.next();
		
		System.out.println("Enter age : ");
		int age=sc.nextInt();
		
		System.out.println("Enter Mob no : ");
		String mob=sc.next();
		
		
		Student student=new Student();
		student.setName(name);
		student.setAge(age);
		student.setCourseName(cname);
		student.setMobileNo(mob);
		int rn=service.addStudent(student);
		System.out.println("Student record added.."+rn);
		break;
		
		case 2 :
			System.out.println("enter rollno to fetch student details");
			int r=sc.nextInt();
			student =service.getStudent(r);
			if(student==null)
				System.out.println("record not found...");
			else{
			System.out.println("Student details of roll no "+r+"are :");
			System.out.println(student.getName());
			System.out.println(student.getAge());
			System.out.println(student.getCourseName());
			System.out.println(student.getMobileNo());
			}
			break;
		
		case 3:
		System.out.println("update the details-----enter roll no");
		r=sc.nextInt();
		student=service.getStudent(r);
		if(student==null)
			System.out.println("record not found");
		else
		{
		System.out.println("enter new mobile number\n");
		String mobn=sc.next();
		student.setMobileNo(mobn);
		student=service.updateStudent(student);
		System.out.println("updated records for rollno: "+r);
		
		System.out.println(student.getName());
		System.out.println(student.getMobileNo());
		
		}
		break;
		case 4:
		System.out.println("enter course name");
		String cn=sc.next();
		ArrayList<Student> list=service.getStudentList(cn);
		if(list.size()==0)
				System.out.println("no student enrolled");
		else
		{
			for(Student s:list){
			System.out.println(s.getName()+"  "+s.getRollno());
			}
				
		}
		break;
			
			
		}}while(ch!=5);
			
		
		
		
		}

}
