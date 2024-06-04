package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Report;

public interface ReportRepository extends JpaRepository<Report,Integer>
{

}
