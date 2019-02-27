package com.capgemini.dao;

import java.util.HashMap;
import com.capgemini.beans.Trainer;

public interface FeedbackDAO {
	public HashMap<Integer, Trainer> addFeedback(Trainer trainer);
	public HashMap<Integer,Trainer> getTrainerList();

}
