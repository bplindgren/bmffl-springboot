package com.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="owners")
@NamedStoredProcedureQuery(
	name="get_all_time_records",
	procedureName="get_all_time_records"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
