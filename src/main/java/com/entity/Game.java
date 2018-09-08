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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="games")
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false)
	@JsonIgnore
	private Season season;

	@Column(nullable=false)
	private int week;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Team awayTeam;

	@Column(nullable=false)
	private float awayScore;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Team homeTeam;

	@Column(nullable=false)
	private float homeScore;

	@Column(nullable=false, length=32)
	private String gameType;

	@Column(nullable=false)
	private boolean completed;

	public int getId() {
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
