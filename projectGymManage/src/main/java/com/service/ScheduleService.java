package com.service;

import java.util.List;
import java.util.Map;

import com.exception.ScheduleNotFoundException;
import com.model.Schedule;

public interface ScheduleService 
{
	public Schedule saveSchedule(Schedule schedule);

	void updateSchedule(Schedule schedule);
	
	Schedule getScheduleById(int id) throws ScheduleNotFoundException;
	
	List<Schedule> getAllSchedule();
	
	public Map<String,Object> deleteSchedule(int id);
}