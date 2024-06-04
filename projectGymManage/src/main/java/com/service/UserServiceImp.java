package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.model.User;

@Service
public class UserServiceImp implements UserService{

	@Autowired
    private UserRepository userRepo;

    @Autowired
    private JavaMailSender mailSender;

	@Override
	public User registerUser(User user) throws Exception {
		 Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
	        if (existingUser.isPresent()) {
	            throw new Exception("User with email " + user.getEmail() + " already registered.");
	        }

	        User savedUser = userRepo.save(user);
	        sendWelcomeEmail(user.getEmail(), user.getUsername());
	        return savedUser;
	    }

//	@Override
//	public User loginUser(String email, String password) throws Exception {
//		 Optional<User> user = userRepo.findByEmail(email);
//	        if (user.isPresent() && user.get().getPassword().equals(password)) {
//	            return user.get();
//	        } else {
//	            throw new Exception("Invalid email or password");
//	        }
//	    }

	    private void sendWelcomeEmail(String to, String name) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Welcome to Our Gym");
	        message.setText("Dear " + name + ",\n\nWelcome to our EmpowerHER Fitness Gym! We are excited to have you with us.\n\nBest regards,\n EmpowerHER Fitness Team");
	        mailSender.send(message);
	    }

}
