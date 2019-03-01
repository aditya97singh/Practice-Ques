package com.capgemini.testing;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import com.capgemini.beans.Trainer;
import com.capgemini.exceptions.InvalidCourseNameException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.exceptions.InvalidRatingException;
import com.capgemini.service.FeedbackService;
import com.capgemini.service.FeedbackServiceImpl;

public class TestC {

	@Before
	public void setUp() throws Exception {
	}

	FeedbackService fs=new FeedbackServiceImpl();
	
	@Test(expected = com.capgemini.exceptions.InvalidNameException.class)
	public void whennameisnotgiven() throws InvalidNameException, InvalidCourseNameException, InvalidRatingException{
		Trainer t = new Trainer(null, "btech",LocalDate.of(2000,04,22), LocalDate.of(2002,05,20), 4);
		fs.addFeedback(t);
	}
	@Test(expected = com.capgemini.exceptions.InvalidNameException.class)
	public void whennameisnotvalid() throws InvalidNameException, InvalidCourseNameException, InvalidRatingException{
		Trainer t = new Trainer("Aditya8", "btech",LocalDate.of(2000,04,22), LocalDate.of(2002,05,20), 4);
		fs.addFeedback(t);
	}
	
	@Test(expected = com.capgemini.exceptions.InvalidCourseNameException.class)
	public void whencoursenameisnotgiven() throws InvalidCourseNameException, InvalidNameException, InvalidRatingException{
		Trainer t = new Trainer("Aditya",null, LocalDate.of(2000,04,22), LocalDate.of(2002,05,20), 4);
		fs.addFeedback(t);
	}
	@Test(expected = com.capgemini.exceptions.InvalidCourseNameException.class)
	public void whencoursenameisnotvalid() throws InvalidCourseNameException, InvalidNameException, InvalidRatingException{
		Trainer t = new Trainer("Aditya", "btech9", LocalDate.of(2000,04,22), LocalDate.of(2002,05,20), 4);
		fs.addFeedback(t);
	}
    @Test(expected = com.capgemini.exceptions.InvalidRatingException.class)
	public void whenratingisnotvalid() throws InvalidRatingException, InvalidNameException, InvalidCourseNameException{
		Trainer t = new Trainer("Aditya", "btechg", LocalDate.of(2000,04,22), LocalDate.of(2002,05,20),9);
		fs.addFeedback(t);
	}
}
