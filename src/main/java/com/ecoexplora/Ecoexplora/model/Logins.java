package com.ecoexplora.Ecoexplora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Logins")

public class Logins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String user;
	private String password;
	
	public Logins(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Logins() {
		
	}
	
}
