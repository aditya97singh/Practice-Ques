package com.capgemini.service;

import java.util.HashMap;
import com.capgemini.beans.Trainer;
import com.capgemini.dao.FeedbackDAO;
import com.capgemini.dao.FeedbackDAOImpl;

public class FeedbackServiceImpl implements FeedbackService {

	FeedbackDAO fd;

	public FeedbackServiceImpl() {
		fd = new FeedbackDAOImpl();
	}

	public HashMap<Integer, Trainer> addFeedback(Trainer trainer) {

		return fd.addFeedback(trainer);

	}

	public HashMap<Integer, Trainer> getTrainerList() {

		return fd.getTrainerList();

	}
}
