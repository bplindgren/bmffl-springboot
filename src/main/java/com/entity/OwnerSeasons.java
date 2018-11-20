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
	private long id;
	
	@Column(name="ownerId", nullable=false)
	private int ownerId;
	
	@Column(name="name", nullable=false)
	private String name;

	@Column(name="seasonId", nullable=false)
	private int seasonId;

	@Column(name="year", nullable=false)
	private String year;

	@Column(name="division", nullable=false)
	private String division;

	@Column(name="firstname", nullable=false)
	private String firstname;

	@Column(name="lastinitial", nullable=false)
	private String lastinitial;

	public long getId() {
		return id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public String getName() {
		return name;
	}

	public int getSeasonId() {
		return seasonId;
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
