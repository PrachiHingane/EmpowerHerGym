package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> 
{

}
