package com.entity;

public class Record {
	
	private Integer wins;
	private Integer losses;
	private Integer ties;
	
	public Record(Integer wins, Integer losses, Integer ties) {
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getTies() {
		return ties;
	}

	public void setTies(Integer ties) {
		this.ties = ties;
	}
	
	
}
