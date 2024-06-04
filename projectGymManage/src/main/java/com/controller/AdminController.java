package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminNotFoundException;
import com.model.Admin;
import com.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController 
{
	@Autowired
	AdminService adminService;
	
	@PostMapping("/addAdmin")
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin) throws AdminNotFoundException
	{
	    Admin updatedAdmin = adminService.updateAdmin(id, admin);
	    return ResponseEntity.status(HttpStatus.OK).header("Update", "Updated details").body(updatedAdmin);
	}
}
