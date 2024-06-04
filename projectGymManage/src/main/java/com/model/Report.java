package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Report 
{
	@Id
	private int reportid;
	private String name;
	private int contactNumber;
	private String membershipStatus;
	private String attendanceRecord;
	private int joiningDate;
	
	public Report() {
		super();
	}

	public Report(int reportid, String name, int contactNumber, String membershipStatus, String attendanceRecord,
			int joiningDate) {
		super();
		this.reportid = reportid;
		this.name = name;
		this.contactNumber = contactNumber;
		this.membershipStatus = membershipStatus;
		this.attendanceRecord = attendanceRecord;
		this.joiningDate = joiningDate;
	}

	public int getReportid() {
		return reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public String getAttendanceRecord() {
		return attendanceRecord;
	}

	public void setAttendanceRecord(String attendanceRecord) {
		this.attendanceRecord = attendanceRecord;
	}

	public int getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(int joiningDate) {
		this.joiningDate = joiningDate;
	}
	
}