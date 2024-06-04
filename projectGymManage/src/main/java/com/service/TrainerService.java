package com.service;

import java.util.List;
import java.util.Map;

import com.exception.TrainerNotFoundException;
import com.model.Trainer;

public interface TrainerService 
{
	public Trainer saveTrainer(Trainer trainer);

//	Trainer updateTrainer(int id,Trainer updatedTrainer);
	
	void updateTrainer(Trainer trainer);
	
	Trainer getTrainerById(int id) throws TrainerNotFoundException;
	
	List<Trainer> getAllTrainer();
	
	public Map<String,Object> deleteTrainer(int id);
}
