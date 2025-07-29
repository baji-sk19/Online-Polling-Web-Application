package com.App.Polling.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userid;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	private String password;
	private String username;
	private String phonenumber;
	private boolean hasVoted = false;

	public boolean isHasVoted() {
		// TODO Auto-generated method stub
		return hasVoted;
	}

	public void setHasVoted(boolean b) {
		// TODO Auto-generated method stub

	}

	public Object getUserid() {
		// TODO Auto-generated method stub
		return null;
	}

}