package com.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
	@SequenceGenerator(name="admin_seq",sequenceName="admin_sequence", allocationSize=1)
	private int adminId;
	private String adminName;
	private String adminEmail;
	private long adminPhno;
	private String adminPwd;

	@OneToMany(fetch=FetchType.EAGER)
	private List<User> user;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Trainer> trainers;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Schedule> schedules;

	public Admin() {
		super();
	}

	public Admin(int adminId, String adminName, String adminEmail, long adminPhno, String adminPwd, List<User> user,
			List<Trainer> trainers, List<Schedule> schedules) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhno = adminPhno;
		this.adminPwd = adminPwd;
		this.user = user;
		this.trainers = trainers;
		this.schedules = schedules;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public long getAdminPhno() {
		return adminPhno;
	}

	public void setAdminPhno(long adminPhno) {
		this.adminPhno = adminPhno;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
