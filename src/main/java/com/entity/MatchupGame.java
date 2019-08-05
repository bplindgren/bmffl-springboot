package com.entity;

public class MatchupGame {
	private long id;
	private String season;
	private int week;
	private String gameType;
	private String o1team;
	private float o1score;
	private String o2team;
	private float o2score;
	private boolean completed;
	
	public MatchupGame(long id, String season, int week, String gameType, String o1team, float o1score, String o2team,
			float o2score, boolean completed) {
		super();
		this.id = id;
		this.season = season;
		this.week = week;
		this.gameType = gameType;
		this.o1team = o1team;
		this.o1score = o1score;
		this.o2team = o2team;
		this.o2score = o2score;
		this.completed = completed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getO1team() {
		return o1team;
	}

	public void setO1team(String o1team) {
		this.o1team = o1team;
	}

	public float getO1score() {
		return o1score;
	}

	public void setO1score(float o1score) {
		this.o1score = o1score;
	}

	public String getO2team() {
		return o2team;
	}

	public void setO2team(String o2team) {
		this.o2team = o2team;
	}

	public float getO2score() {
		return o2score;
	}

	public void setO2score(float o2score) {
		this.o2score = o2score;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
