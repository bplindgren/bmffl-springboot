package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="seasons")
//@NamedStoredProcedureQuery(
//	name = "get_owner_seasons", 
//	procedureName = "get_owner_seasons",
//	parameters = {
//		@StoredProcedureParameter(
//			mode = ParameterMode.IN,
//			name = "owner_",
//			type = Integer.class)
//	}
//)
public class Season {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	
	@Column(nullable=false, length=8)
	private String year;
	
	@OneToMany(mappedBy="season")
	@JsonIgnore
	private Set<Team> teams;
	
	@Column(nullable=false)
	private boolean completed;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=true)
	private Team champion;

	public int getId() {
		return id;
	}

	public String getYear() {
		return year;
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public Team getChampion() {
		return champion;
	}

}
