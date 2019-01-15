package com.entity;

import java.util.List;

public class MatchupStats {
	
	private List<Game> games;
	private int o1wins;
	private int o2wins;
	private int ties;
	private float o1points;
	private float o2points;
	
	public MatchupStats(List<Game> games, int o1wins, int o2wins, int ties, float o1points, float o2points) {
		this.games = games;
		this.o1wins = o1wins;
		this.o2wins = o2wins;
		this.ties = ties;
		this.o1points = o1points;
		this.o2points = o2points;
	}

	public List<Game> getGames() {
		return games;
	}

	public int getO1wins() {
		return o1wins;
	}

	public int getO2wins() {
		return o2wins;
	}

	public int getTies() {
		return ties;
	}

	public float getO1points() {
		return o1points;
	}

	public float getO2points() {
		return o2points;
	}
	
}
