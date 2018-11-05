package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="teams")
@NamedStoredProcedureQuery(
	name = "get_week_record", 
	procedureName = "get_week_record",
	parameters = { 
		@StoredProcedureParameter(
			mode = ParameterMode.IN,
			name = "team_", 
			type = Long.class),
		@StoredProcedureParameter(
			mode = ParameterMode.IN,
			name = "week_", 
			type = Long.class)
	}
)
public class Team implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;

	@Column(nullable=false, length=64)
	private String name;
	
	@Column(nullable=false, length=8)
	private String abbr;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false)
	private Owner owner;
	
	@Column(nullable=false, length=4)
	private String year;

	@ManyToOne
	@JoinColumn(nullable=false)
	@JsonIgnore
	private Season season;	
	
	@Column(nullable=false, length=16)
	private String division;
	
	@Column(nullable=true, length=1)
	private Integer standing;
	
	@Column(nullable=true, length=2)
	private int gamesPlayed;
	
	@Column(nullable=true, length=2)
	private int wins;
	
	@Column(nullable=true, length=2)
	private int winsRegSeason;
	
	@Column (nullable=true, length=2)
	private int losses;
	
	@Column (nullable=true, length=2)
	private int lossesRegSeason;
	
	@Column (nullable=true, length=1)
	private int ties;
	
	@Column(nullable=true, length=8)
	private String divisionWinner;
	
	@Column(nullable=true, length=8)
	private String champion;
	
	@Column(nullable=true, length=8)
	private float pointsFor;
	
	@Column(nullable=true, length=8)
	private float pointsAgainst;
	
	@OneToMany(mappedBy="homeTeam")
	@JsonIgnore
	private List<Game> homeGames;
	
	@OneToMany(mappedBy="awayTeam")
	@JsonIgnore
	private List<Game> awayGames;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}

	public Owner getOwner() {
		return owner;
	}

	public String getYear() {
		return year;
	}

	public Season getSeason() {
		return season;
	}

	public String getDivision() {
		return division;
	}

	public Integer getStanding() {
		return standing;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getWins() {
		return wins;
	}

	public int getWinsRegSeason() {
		return winsRegSeason;
	}

	public int getLosses() {
		return losses;
	}

	public int getLossesRegSeason() {
		return lossesRegSeason;
	}

	public int getTies() {
		return ties;
	}

	public String getDivisionWinner() {
		return divisionWinner;
	}

	public String getChampion() {
		return champion;
	}

	public float getPointsFor() {
		return pointsFor;
	}

	public float getPointsAgainst() {
		return pointsAgainst;
	}

	public List<Game> getHomeGames() {
		return homeGames;
	}

	public List<Game> getAwayGames() {
		return awayGames;
	}
	
}
