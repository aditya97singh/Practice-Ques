package com.capgemini.util;

import java.time.LocalDate;
import java.util.HashMap;

import com.capgemini.beans.Trainer;

public class DBUtil {

static HashMap<Integer,Trainer> feedbackList=new HashMap<>();
	
	static{
		feedbackList.put(41,new Trainer("Smitha","Java",LocalDate.of(2000, 03,13),LocalDate.of(2000,04, 10),5));
		feedbackList.put(22,new Trainer("Smitha","Java",LocalDate.of(2001,01,01),LocalDate.of(2001,01,10),4));
		feedbackList.put(43,new Trainer("Smitha","Java",LocalDate.of(2001,10,13),LocalDate.of(2001,10,23),3));

}	
	
	public static int getId()
	{
		return (int) (Math.random()*1000);
	}
	
	public static HashMap<Integer, Trainer> getTrainerList() {	
		return (HashMap<Integer, Trainer>) feedbackList;

	}
}
