package com.model;


import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Schedule
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="schedule_seq")
	@SequenceGenerator(name="schedule_seq",sequenceName="schedule_sequence", allocationSize=1)
	private int scheduleId;

    private LocalTime startTime;
    private LocalTime endTime;
    
    private String workoutType;

	public Schedule() {
		super();
	}

	public Schedule(int scheduleId, LocalTime startTime, LocalTime endTime, String workoutType) {
		super();
		this.scheduleId = scheduleId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.workoutType = workoutType;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}
    
}

