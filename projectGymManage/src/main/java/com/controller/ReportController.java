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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Report;
import com.service.ReportService;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class ReportController 
{
	@Autowired
	ReportService reportService;
	
	@PostMapping("/save")
	public ResponseEntity<Report> addreport(@RequestBody Report report)
	{
		Report r= reportService.savereport(report);
		return ResponseEntity.status(HttpStatus.CREATED).header("add","report Created").body(r);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Report> addreport(@PathVariable int id)
	{
		Report r = reportService.getreportById(id);
		return ResponseEntity.status(HttpStatus.OK).header("add","report Created").body(r);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Report> > findAllreport()
	{
		List<Report> r = reportService.getAllreport();
		return ResponseEntity.status(HttpStatus.OK).header("GET","All Report Found").body(r);
		  
	}
	
	@GetMapping("/updatereport")
	public ResponseEntity<Report>  updatereport(@RequestBody Report report)
	{
		Report r = reportService.updatereport(report);
		return ResponseEntity.status(HttpStatus.OK).header("UPDATE","update Report").body(r);
		
	}
	
	@DeleteMapping("/deletereport/{id}")
	public ResponseEntity<Map<String,Object>>  deletereport(@PathVariable int id)
	{
		Map<String, Object> response = reportService.deletereport(id);	
		return ResponseEntity.ok(response);
	}

}