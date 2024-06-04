package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.exception.AdminNotFoundException;
import com.model.Admin;

@Service
public class AdminServiceImp implements AdminService
{
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin saveAdmin(Admin admin) 
	{
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) throws AdminNotFoundException 
	{
		Admin a1 = adminRepo.findById(id).orElseThrow(()-> new AdminNotFoundException("ADMIN DOES NOT Exist"+id));
		a1.setAdminName(admin.getAdminName());
		a1.setAdminEmail(admin.getAdminEmail());
		a1.setAdminPhno(admin.getAdminPhno());
		a1.setAdminPwd(admin.getAdminPwd());
		return adminRepo.save(a1);
	}
	
}

