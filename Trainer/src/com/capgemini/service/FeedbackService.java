package com.capgemini.service;

import java.util.HashMap;
import com.capgemini.beans.Trainer;
import com.capgemini.exceptions.InvalidCourseNameException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.exceptions.InvalidRatingException;

public interface FeedbackService {

	public void addFeedback(Trainer trainer);
	public HashMap<Integer,Trainer> getTrainerList();
	public boolean validateName(String name) throws InvalidNameException;
	public boolean validateCourseName(String cname) throws InvalidCourseNameException;
	public boolean validateRating(int r) throws InvalidRatingException;
}
