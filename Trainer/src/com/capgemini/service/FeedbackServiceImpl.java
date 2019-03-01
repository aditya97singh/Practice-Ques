package com.capgemini.service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.beans.Trainer;
import com.capgemini.dao.FeedbackDAO;
import com.capgemini.dao.FeedbackDAOImpl;
import com.capgemini.exceptions.InvalidCourseNameException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.exceptions.InvalidRatingException;

public class FeedbackServiceImpl implements FeedbackService {

	FeedbackDAO fd;

	public FeedbackServiceImpl() {
		fd = new FeedbackDAOImpl();
	}

	@Override
	public String addFeedback(Trainer trainer) throws InvalidNameException, InvalidCourseNameException, InvalidRatingException 
	{
		if(validateName(trainer.getName()) && validateCourseName(trainer.getCourseName()) && validateRating(trainer.getRating()))
		{
		 fd.addFeedback(trainer);
		}
		return trainer.getName();
	}

	@Override
	public HashMap<Integer, Trainer> getTrainerList(int r) {
		return fd.getTrainerList(r);
	}
	
	@Override
	public boolean validateName(String name) throws InvalidNameException
	{
		if(name==null)
			throw new InvalidNameException();
		Pattern p=Pattern.compile("[Aza-z]{1,20}");
		Matcher m=p.matcher(name);
		if(!(m.matches()))
			throw new InvalidNameException();	
		return m.matches();	
	  
	}
	@Override
	public boolean validateCourseName(String cname) throws InvalidCourseNameException
	{
		if(cname==null)
			throw new InvalidCourseNameException();
		Pattern p=Pattern.compile("[Aza-z]{1,20}");
		Matcher m=p.matcher(cname);
		if(!(m.matches()))
			throw new InvalidCourseNameException();	
		return m.matches();	

	}
	@Override
	public boolean validateRating(int r) throws InvalidRatingException
	{
		if(r<0 || r>6)
			throw new InvalidRatingException();
		return true;
	}

}
