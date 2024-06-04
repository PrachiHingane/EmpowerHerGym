package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.TrainerNotFoundException;
import com.model.Trainer;
import com.service.TrainerService;

@RestController
@RequestMapping("/t")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController 
{
	@Autowired
	TrainerService trainerService;
	
	@PostMapping("/addTrainer")
	public Trainer saveTrainer(@RequestBody Trainer trainer)
	{
		return trainerService.saveTrainer(trainer);
	}
	
	@GetMapping("/getAllTrainers")
	public ResponseEntity<List<Trainer>>findAllTrainer()
	{
		List<Trainer> t1 = trainerService.getAllTrainer();
		return ResponseEntity.status(HttpStatus.OK).header("GET", "All Trainers Found").body(t1);
	}
	
	@GetMapping("/getTrainerById/{id}")
	public ResponseEntity<Trainer> addTrainer(@PathVariable int id) throws TrainerNotFoundException
	{
		Trainer t1 = trainerService.getTrainerById(id);
		return ResponseEntity.status(HttpStatus.OK).header("GET", "Trainer Found").body(t1);
	}
	
	@PutMapping("/updateTrainers")
	public ResponseEntity<String> updateTrainer(@RequestBody Trainer trainer)
	{
		trainerService.updateTrainer(trainer);
		return ResponseEntity.ok("Updated Trainer Successfuly");
	}
	
	@DeleteMapping("/deleteTrainerById/{id}")
	public ResponseEntity<Map<String, Object>> deleteTrainer(@PathVariable("id") int id)
	{
		Map<String, Object> response = trainerService.deleteTrainer(id);
		return ResponseEntity.ok(response);
	}
	
}

/*
	@PutMapping("/updateTrainer/{id}")
	public ResponseEntity<Trainer> updateTrainer(@PathVariable("id") int id, @RequestBody Trainer trainer) throws TrainerNotFoundException
	{
		Trainer t1 = trainerService.updateTrainer(id,trainer);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Updated Trainer").body(t1);
	}
*/
