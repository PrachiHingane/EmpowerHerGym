package com.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Membership;

public interface MembershipRepository extends JpaRepository <Membership, Long>{

	Optional<Membership> findByUsername(String username);

}