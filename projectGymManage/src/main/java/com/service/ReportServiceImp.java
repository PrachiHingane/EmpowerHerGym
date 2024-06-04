package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReportRepository;
import com.model.Report;

@Service
public class ReportServiceImp implements ReportService
{
	@Autowired
	ReportRepository reportRepo;
	
	@Override
	public Report savereport(Report report) 
	{
		return reportRepo.save(report);
	}

	@Override
	public Report getreportById(int id)
	{
		return reportRepo.findById(id).orElse(null);
	}

	@Override
	public List<Report> getAllreport() 
	{
		return reportRepo.findAll();
	}

	@Override
	public Report updatereport(Report report) 
	{
		Report existingreport = reportRepo.findById(report.getReportid()).orElse(report);
		existingreport.setMembershipStatus("Active");
		Report updatereport= reportRepo.save(existingreport);
		return updatereport;
	}

	@Override
	public Map<String, Object> deletereport(int id) 
	{
		Map<String , Object> response = new HashMap<>();
		Report report = reportRepo.findById(id).orElse(null);
		if(report==null)
		{
			response.put("not deleted", "report not deleted because id is  not found");
		}
		else
		{
			reportRepo.delete(report);
		response.put("deleted", "report deleted sucessfully");
		}
		return response;
	}
	
}
