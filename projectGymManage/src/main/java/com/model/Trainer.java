package com.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Trainer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="trainer_seq")
	@SequenceGenerator(name="trainer_seq",sequenceName="trainer_sequence", allocationSize=1)
	private int trainerId;
	private String trainerName;
	private String trainerEmail;
	private String trainerExperience;
	private long trainerPhno;
	private int trainerPwd;
	private int trainerSalary;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Schedule> schedules;

	public Trainer() {
		super();
	}

	public Trainer(int trainerId, String trainerName, String trainerEmail, String trainerExperience, long trainerPhno,
			int trainerPwd, int trainerSalary, List<Schedule> schedules) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
		this.trainerExperience = trainerExperience;
		this.trainerPhno = trainerPhno;
		this.trainerPwd = trainerPwd;
		this.trainerSalary = trainerSalary;
		this.schedules = schedules;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public String getTrainerExperience() {
		return trainerExperience;
	}

	public void setTrainerExperience(String trainerExperience) {
		this.trainerExperience = trainerExperience;
	}

	public long getTrainerPhno() {
		return trainerPhno;
	}

	public void setTrainerPhno(long trainerPhno) {
		this.trainerPhno = trainerPhno;
	}

	public int getTrainerPwd() {
		return trainerPwd;
	}

	public void setTrainerPwd(int trainerPwd) {
		this.trainerPwd = trainerPwd;
	}

	public int getTrainerSalary() {
		return trainerSalary;
	}

	public void setTrainerSalary(int trainerSalary) {
		this.trainerSalary = trainerSalary;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}
