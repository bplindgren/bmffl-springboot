package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private long id;
	
	@Column(nullable=false)
	private String firstname;
	
	@Column(nullable=false)
	private String lastname;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@Column
	private String favbmfflteam;
	
	@Column
	private String favnflteam;
	
	@Column(nullable=false)
	private Boolean active;
	
	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFavbmfflteam() {
		return favbmfflteam;
	}

	public void setFavbmfflteam(String favbmfflteam) {
		this.favbmfflteam = favbmfflteam;
	}

	public String getFavnflteam() {
		return favnflteam;
	}

	public void setFavnflteam(String favnflteam) {
		this.favnflteam = favnflteam;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
