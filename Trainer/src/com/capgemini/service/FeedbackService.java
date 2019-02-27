package com.capgemini.service;

import java.util.HashMap;
import com.capgemini.beans.Trainer;

public interface FeedbackService {

	public HashMap<Integer, Trainer> addFeedback(Trainer trainer);
	public HashMap<Integer,Trainer> getTrainerList();
}
