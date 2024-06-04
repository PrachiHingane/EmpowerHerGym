package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrainerRepository;
import com.exception.TrainerNotFoundException;
import com.model.Trainer;

@Service
public class TrainerServiceImp implements TrainerService
{
	@Autowired
	TrainerRepository trainerRepo;

	@Override
	public Trainer saveTrainer(Trainer trainer)
	{
		return trainerRepo.save(trainer);
	}
	
	@Override
	public Trainer getTrainerById(int id) throws TrainerNotFoundException 
	{
		return trainerRepo.findById(id).orElseThrow(()-> new TrainerNotFoundException("Trainer DOES NOT Exist"+id));
	}

	@Override
	public List<Trainer> getAllTrainer() 
	{
		return trainerRepo.findAll();
	}
	
	@Override
	public void updateTrainer(Trainer trainer)
	{
		trainerRepo.save(trainer);
	}

	@Override
	public Map<String, Object> deleteTrainer(int id) 
	{
		Map<String, Object> response = new HashMap<>();
		
		Trainer trainer = trainerRepo.findById(id).orElse(null);
		if(trainer==null)
		{
			response.put("NOT DELETED", "trainer not deleted");
		}
		else
		{
			trainerRepo.deleteById(id);
			response.put("DELETED", "trainer deleted sucessfully");
		}
		return response;
	}
	
}

//@Override
//public Trainer updateTrainer(int id, Trainer trainer) throws TrainerNotFoundException 
//{
//	Trainer existingTrainer = trainerRepo.findById(trainer.getTrainerId()).orElseThrow(()-> new TrainerNotFoundException("Trainer DOES NOT Exist"+id));
//	existingTrainer.setTrainerName(trainer.getTrainerName());
//	existingTrainer.setTrainerEmail(trainer.getTrainerEmail());
//	existingTrainer.setTrainerExperience(trainer.getTrainerExperience());
//	existingTrainer.setTrainerPhno(trainer.getTrainerPhno());
//	existingTrainer.setTrainerPwd(trainer.getTrainerPwd());
//	existingTrainer.setTrainerSalary(trainer.getTrainerSalary());
//	
//	Trainer updatedTrainer = trainerRepo.save(existingTrainer);
//	return updatedTrainer;
//}
