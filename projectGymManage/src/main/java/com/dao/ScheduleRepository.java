package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
