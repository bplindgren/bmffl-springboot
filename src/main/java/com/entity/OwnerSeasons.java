package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mv_owner_seasons")
public class OwnerSeasons {
	
	@Id
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="owner_Id", nullable=false)
	private int owner_Id;
	
	@Column(name="name", nullable=false)
	private String name;

	@Column(name="season_Id", nullable=false)
	private String season_Id;

	@Column(name="year", nullable=false)
	private String year;

	@Column(name="division", nullable=false)
	private String division;

	@Column(name="firstname", nullable=false)
	private String firstname;

	@Column(name="lastinitial", nullable=false)
	private String lastinitial;

	public int getId() {
		return id;
	}

	public int getOwner_Id() {
		return owner_Id;
	}

	public String getName() {
		return name;
	}

	public String getSeason_Id() {
		return season_Id;
	}

	public String getYear() {
		return year;
	}

	public String getDivision() {
		return division;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastinitial() {
		return lastinitial;
	}
	
	
}
