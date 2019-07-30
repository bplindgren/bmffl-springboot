package com.entity;

public class TeamGame {
	private int week;
	private String team;
	private String owner;
	private String home;
	private String opposingTeam;
	private long opposingTeamId;
	private String opposingOwner;
	private long opposingOwnerId;
	private String division;
	private String result;
	private float teamScore;
	private float opponentScore;
	private String gameType;
	private short w;
	private short l;
	private short t;
	private String fullStreak;
	
	public TeamGame(int week, String team, String owner, String home, String opposingTeam, long opposingTeamId,
			String opposingOwner, long opposingOwnerId, String division, String result,
			float teamScore, float opponentScore, String gameType, short w, short l, short t, String fullStreak) {
		this.week = week;
		this.team = team;
		this.owner = owner;
		this.home = home;
		this.opposingTeam = opposingTeam;
		this.opposingTeamId = opposingTeamId;
		this.opposingOwner = opposingOwner;
		this.opposingOwnerId = opposingOwnerId;
		this.division = division;
		this.result = result;
		this.teamScore = teamScore;
		this.opponentScore = opponentScore;
		this.gameType = gameType;
		this.w = w;
		this.l = l;
		this.t = t;
		this.fullStreak = fullStreak;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getOpposingTeam() {
		return opposingTeam;
	}

	public void setOpposingTeam(String opposingTeam) {
		this.opposingTeam = opposingTeam;
	}

	public long getOpposingTeamId() {
		return opposingTeamId;
	}

	public void setOpposingTeamId(long opposingTeamId) {
		this.opposingTeamId = opposingTeamId;
	}

	public String getOpposingOwner() {
		return opposingOwner;
	}

	public void setOpposingOwner(String opposingOwner) {
		this.opposingOwner = opposingOwner;
	}

	public long getOpposingOwnerId() {
		return opposingOwnerId;
	}

	public void setOpposingOwnerId(long opposingOwnerId) {
		this.opposingOwnerId = opposingOwnerId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public float getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(float teamScore) {
		this.teamScore = teamScore;
	}

	public float getOpponentScore() {
		return opponentScore;
	}

	public void setOpponentScore(float opponentScore) {
		this.opponentScore = opponentScore;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public short getW() {
		return w;
	}

	public void setW(short w) {
		this.w = w;
	}

	public short getL() {
		return l;
	}

	public void setL(short l) {
		this.l = l;
	}

	public short getT() {
		return t;
	}

	public void setT(short t) {
		this.t = t;
	}

	public String getFullStreak() {
		return fullStreak;
	}

	public void setFullStreak(String fullStreak) {
		this.fullStreak = fullStreak;
	}

}