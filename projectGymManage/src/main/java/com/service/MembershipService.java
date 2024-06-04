package com.service;

import java.util.List;

import com.model.Membership;

public interface MembershipService
{
	    Membership createMembership(Membership membership) throws Exception;
	    
	    Membership updateMembership(Long id, Membership membership) throws Exception;
	    
	    void deleteMembership(Long id) throws Exception;
	    
	    Membership getMembershipById(Long id) throws Exception;
	    
	    List<Membership> getAllMemberships();
	    
	    Membership login(String username, String password) throws Exception; // New method
}