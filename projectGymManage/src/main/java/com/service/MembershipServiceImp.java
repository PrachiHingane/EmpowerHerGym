package com.service;

import java.security.SecureRandom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dao.MembershipRepository;
import com.model.Membership;

@Service
public class MembershipServiceImp implements MembershipService{

	@Autowired
    private MembershipRepository membershipRepo;

	@Autowired
	private JavaMailSender mailSender;

	@Override
    public Membership createMembership(Membership membership) throws Exception {
		 membership.setUsername(generateUsername(membership.getMemberName()));
	     membership.setPassword(generatePassword());
	     Membership savedMembership = membershipRepo.save(membership);
	     sendCredentialsEmail(membership.getEmail(), membership.getUsername(), membership.getPassword());
	        return savedMembership;
    }

	@Override
	public Membership updateMembership(Long id, Membership membership) throws Exception {
		 Membership existingMembership = membershipRepo.findById(id).orElse(null);
	        if (existingMembership==null) {
	            throw new Exception("Membership not found with id: " + id);	
	            }
	        membership.setId(id);
	        return membershipRepo.save(membership);
	}

	@Override
	public void deleteMembership(Long id) throws Exception {
		if (!membershipRepo.existsById(id)) {
            throw new Exception("Membership not found with id: " + id);
        }
        membershipRepo.deleteById(id);

	}

	@Override
	public Membership getMembershipById(Long id) throws Exception {
		   return membershipRepo.findById(id)
	          .orElseThrow(() -> new Exception("Membership not found with id: " + id));
	}

	@Override
	public List<Membership> getAllMemberships() {
		return membershipRepo.findAll();

	}

	@Override
    public Membership login(String username, String password) throws Exception {
        Optional<Membership> membership = membershipRepo.findByUsername(username);
        if (membership.isPresent() && membership.get().getPassword().equals(password)) {
            return membership.get();
        } else {
            throw new Exception("Invalid username or password");
        }
    }

	private String generateUsername(String memberName) {
        return memberName.toLowerCase().replaceAll("\\s+", "") + new SecureRandom().nextInt(1000);
    }

    private String generatePassword() {
        SecureRandom random = new SecureRandom();
        int length = 8;
        StringBuilder password = new StringBuilder(length);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$&*";
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    private void sendCredentialsEmail(String to, String username, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your to EmpowerHER Fitness Gym Membership Credentials");
        message.setText("Dear Member,\n\nWelcome to our gym! Here are your login credentials:\n\nUsername: " + username + "\nPassword: " + password + "\n\nBest regards,\n EmpowerHER Fitness Gym Team");
        mailSender.send(message);
    }
}


