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
import org.springframework.web.bind.annotation.RestController;

import com.exception.ScheduleNotFoundException;
import com.model.Schedule;
import com.service.ScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController
{
	@Autowired
	ScheduleService scheduleService;
	
	@PostMapping("/addSchedule")
	public Schedule saveSchedule(@RequestBody Schedule schedule)
	{
		return scheduleService.saveSchedule(schedule);
	}
	
	@GetMapping("/getAllSchedules")
	public ResponseEntity<List<Schedule>>findAllSchedule()
	{
		List<Schedule> s1 = scheduleService.getAllSchedule();
		return ResponseEntity.status(HttpStatus.OK).header("GET", "All Schedules Found").body(s1);
	}
	
	@GetMapping("/getScheduleById/{id}")
	public ResponseEntity<Schedule> addSchedule(@PathVariable int id) throws ScheduleNotFoundException
	{
		Schedule t1 = scheduleService.getScheduleById(id);
		return ResponseEntity.status(HttpStatus.OK).header("GET", "Schedule Found").body(t1);
	}

	@PutMapping("/updateSchedules")
	public ResponseEntity<String> updateSchedule(@RequestBody Schedule schedule)
	{
		scheduleService.updateSchedule(schedule);
		return ResponseEntity.ok("Updated Schedule Successfuly");
	}
	
	@DeleteMapping("/deleteScheduleById/{id}")
	public ResponseEntity<Map<String, Object>> deleteSchedule(@PathVariable("id") int id)
	{
		Map<String, Object> response = scheduleService.deleteSchedule(id);
		return ResponseEntity.ok(response);
	}
	
}
