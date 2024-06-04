package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String memberName;
    private String email;
    private String phoneNo;
    private Double height;
    private Double weight;
    private Integer age;
    private String weightProblem;
    private String membershipType;
    private String username;
    private String password;
    private Double amount;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

	public Membership() {
		super();
	}

	public Membership(Long id, String memberName, String email, String phoneNo, Double height, Double weight,
			Integer age, String weightProblem, String membershipType, String username, String password, Double amount) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.weightProblem = weightProblem;
		this.membershipType = membershipType;
		this.username = username;
		this.password = password;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getWeightProblem() {
		return weightProblem;
	}

	public void setWeightProblem(String weightProblem) {
		this.weightProblem = weightProblem;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", memberName=" + memberName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", height=" + height + ", weight=" + weight + ", age=" + age + ", weightProblem=" + weightProblem
				+ ", membershipType=" + membershipType + ", username=" + username + ", password=" + password
				+ ", amount=" + amount + "]";
	}
}
