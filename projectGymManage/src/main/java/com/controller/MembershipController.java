package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Membership;
import com.service.MembershipService;

@RestController
@RequestMapping("/api/memberships")
@CrossOrigin(origins="http://localhost:4200")
public class MembershipController {

	 @Autowired
	    private MembershipService membershipService;

	    @PostMapping("/create")
	    public ResponseEntity<String> createMembership(@RequestBody Membership membership) {
	        try {
	            membershipService.createMembership(membership);
	            return ResponseEntity.ok("Membership created successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateMembership(@PathVariable Long id, @RequestBody Membership membership) {
	        try {
	            membershipService.updateMembership(id, membership);
	            return ResponseEntity.ok("Membership updated successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteMembership(@PathVariable Long id) {
	        try {
	            membershipService.deleteMembership(id);
	            return ResponseEntity.ok("Membership deleted successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<Membership> getMembershipById(@PathVariable Long id) {
	        try {
	            Membership membership = membershipService.getMembershipById(id);
	            return ResponseEntity.ok(membership);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(null);
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Membership>> getAllMemberships() {
	        return ResponseEntity.ok(membershipService.getAllMemberships());
	    }

	    @PostMapping("/login/{username}/{password}")
	    public ResponseEntity<String> login(@PathVariable("username") String username, @PathVariable("password") String password) {
	        try {
	            membershipService.login(username, password);
	            return ResponseEntity.ok("Login successful");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	}
