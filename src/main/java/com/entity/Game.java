package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="games")
@NamedStoredProcedureQuery(
	name = "get_matchup_games",
	procedureName = "get_matchup_games",
	parameters = {
		@StoredProcedureParameter(
			mode = ParameterMode.IN,
			name = "owner1",
			type = Long.class),
		@StoredProcedureParameter(
			mode = ParameterMode.IN,
			name = "owner2",
			type = Long.class)
	}
)
public class Game {
	
	public Game() {}

	public Game(long id, Season season, int week, Team awayTeam, float awayScore, Team homeTeam, float homeScore,
			String gameType, boolean completed) {
		this.id = id;
		this.season = season;
		this.week = week;
		this.awayTeam = awayTeam;
		this.awayScore = awayScore;
		this.homeTeam = homeTeam;
		this.homeScore = homeScore;
		this.gameType = gameType;
		this.completed = completed;
	}

	public Game(long id, int week, Team awayTeam, float awayScore, Team homeTeam, float homeScore,
			String gameType, boolean completed) {
		this.id = id;
		this.week = week;
		this.awayTeam = awayTeam;
		this.awayScore = awayScore;
		this.homeTeam = homeTeam;
		this.homeScore = homeScore;
		this.gameType = gameType;
		this.completed = completed;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	public long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false)
	@JsonIgnore
	public Season season;

	@Column(nullable=false)
	public int week;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	public Team awayTeam;

	@Column(nullable=false)
	public float awayScore;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	public Team homeTeam;

	@Column(nullable=false)
	public float homeScore;

	@Column(nullable=false, length=32)
	public String gameType;

	@Column(nullable=false)
	public boolean completed;
	
	public long getId() {
		return id;
	}

	public Season getSeason() {
		return season;
	}

	public int getWeek() {
		return week;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public float getAwayScore() {
		return awayScore;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public float getHomeScore() {
		return homeScore;
	}

	public String getGameType() {
		return gameType;
	}

	public boolean isCompleted() {
		return completed;
	}

	@JsonIgnore
	public Team getWinner() throws Exception {
		if (homeScore > awayScore) {
			return homeTeam;
		} else if (awayScore > homeScore) {
			return awayTeam;
		} else {
			throw new Exception("tied");
		}
	}
	
}
