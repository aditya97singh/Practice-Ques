package com.capgemini.testing;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import com.capgemini.beans.Trainer;
import com.capgemini.exceptions.InvalidCourseNameException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.service.FeedbackService;
import com.capgemini.service.FeedbackServiceImpl;

public class TestC {

	@Before
	public void setUp() throws Exception {
	}

	FeedbackService fs=new FeedbackServiceImpl();
	
	@Test //(expected = com.capgemini.exceptions.InvalidCourseNameException.class)
	public void whennameisnotgiven() throws InvalidNameException{
		Trainer t = new Trainer("Aditya9", "btech",LocalDate.of(2000,04,22), LocalDate.of(2002,05,20), 4);
		fs.addFeedback(t);
	}
	
	@Test //(expected = com.capgemini.exceptions.InvalidCourseNameException.class)
	public void whencoursenameisnotgiven() throws InvalidCourseNameException{
		Trainer t = new Trainer("Aditya", "btech9", LocalDate.of(2000,04,22), LocalDate.of(2002,05,20), 4);
		fs.addFeedback(t);
	}
}
