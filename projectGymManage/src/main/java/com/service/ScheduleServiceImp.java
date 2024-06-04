package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ScheduleRepository;
import com.exception.ScheduleNotFoundException;
import com.model.Schedule;

@Service
public class ScheduleServiceImp implements ScheduleService 
{
	@Autowired
	ScheduleRepository scheduleRepo;

	@Override
	public Schedule saveSchedule(Schedule schedule) 
	{
		return scheduleRepo.save(schedule);
	}

	@Override
	public void updateSchedule(Schedule schedule) 
	{
		scheduleRepo.save(schedule);
		
	}

	@Override
	public Schedule getScheduleById(int id) throws ScheduleNotFoundException
	{
		return scheduleRepo.findById(id).orElseThrow(()-> new ScheduleNotFoundException("Schedule DOES NOT Exist"+id));
	}

	@Override
	public List<Schedule> getAllSchedule() 
	{
		return scheduleRepo.findAll();
	}

	@Override
	public Map<String, Object> deleteSchedule(int id) 
	{
		Map<String, Object> response = new HashMap<>();
		
		Schedule schedule = scheduleRepo.findById(id).orElse(null);
		if(schedule==null)
		{
			response.put("NOT DELETED", "schedule not deleted");
		}
		else
		{
			scheduleRepo.deleteById(id);
			response.put("DELETED", "schedule deleted sucessfully");
		}
		return response;
		
	}

}
