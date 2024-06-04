package com.service;

import java.util.List;
import java.util.Map;

import com.model.Report;

public interface ReportService 
{
	Report savereport(Report report);
	
	Report getreportById(int id);
	
	List<Report> getAllreport();
	
	Report updatereport(Report report);
	
	public Map<String,Object> deletereport(int id);

}