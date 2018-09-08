package com.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="owners")
public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(nullable=false, length=8)
	private String firstName;
	
	@Column(nullable=false, length=8)
	private String lastInitial;
	
	@Column(nullable=false, length=12)
	private String division;
	
	@OneToMany(mappedBy="owner")
	@JsonIgnore
	private Set<Team> teams;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastInitial() {
		return lastInitial;
	}

	public void setLastInitial(String lastInitial) {
		this.lastInitial = lastInitial;
	}
	

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Set<Team> getTeams() {
		return teams;
	}
	
}
