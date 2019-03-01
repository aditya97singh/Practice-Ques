package com.capgemini.service;

import java.util.HashMap;
import com.capgemini.beans.Trainer;
import com.capgemini.exceptions.InvalidCourseNameException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.exceptions.InvalidRatingException;

public interface FeedbackService {

	public String addFeedback(Trainer trainer) throws InvalidNameException, InvalidCourseNameException, InvalidRatingException;
	public HashMap<Integer,Trainer> getTrainerList(int r);
	public boolean validateName(String name) throws InvalidNameException;
	public boolean validateCourseName(String cname) throws InvalidCourseNameException;
	public boolean validateRating(int r) throws InvalidRatingException;
}
