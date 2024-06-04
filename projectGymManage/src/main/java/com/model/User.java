package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String email;
	    private String phone;
//	    private String password;

	    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	    private Membership membership;

		public User() {
			super();
		}
		public User(Long id, String username, String email, String phone/*, String password*/) {
			super();
			this.id = id;
			this.username = username;
			this.email = email;
			this.phone = phone;
//			this.password = password;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		@Override
//		public String toString() {
//			return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password="
//					+ password + "]";
//		}
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone
					+ ", membership=" + membership + "]";
		}

}
