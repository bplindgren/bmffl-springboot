package com.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private long id;
	
	@Column(nullable=false, length=8)
	private String firstName;
	
	@Column(nullable=false, length=8)
	private String lastInitial;
	
	@Column(nullable=false, length=12)
	private String division;
	
	@OneToMany(mappedBy="owner")
	@JsonIgnore
	private List<Team> teams;

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastInitial() {
		return lastInitial;
	}
	
	public String getDivision() {
		return division;
	}

	public List<Team> getTeams() {
		return teams;
	}
	
}
