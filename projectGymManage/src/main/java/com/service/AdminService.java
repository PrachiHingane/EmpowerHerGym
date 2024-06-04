package com.service;

import com.exception.AdminNotFoundException;
import com.model.Admin;

public interface AdminService 
{
	public Admin saveAdmin(Admin admin);

	public Admin updateAdmin(int id,Admin admin) throws AdminNotFoundException;
}
