package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="all_time_standings_view")
public class AllTimeStandingsView {

	@Id
	@Column(name="owner_id", nullable=false)
	private int owner_id;
	
	@Column(name="firstname", nullable=false)
	private String firstname;

	@Column(name="lastinitial", nullable=false)
	private String lastinitial;

	@Column(name="seasons", nullable=false)
	private Long seasons;
	
	@Column(name="wins", nullable=false)
	private Long wins;
	
	@Column(name="losses", nullable=false)
	private Long losses;
	
	@Column(name="ties", nullable=false)
	private Long ties;
	
	@Column(name="winning_pct", nullable=false)
	private float winning_pct;
	
	@Column(name="points_for", nullable=false)
	private int points_for;
	
	@Column(name="points_against", nullable=false)
	private int points_against;
	
	@Column(name="point_differential", nullable=false)
	private int point_differential;
	
	@Column(name="pfpg", nullable=false)
	private int pfpg;
	
	@Column(name="papg", nullable=false)
	private int papg;

	public int getOwner_id() {
		return owner_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastinitial() {
		return lastinitial;
	}

	public Long getSeasons() {
		return seasons;
	}

	public Long getWins() {
		return wins;
	}

	public Long getLosses() {
		return losses;
	}

	public Long getTies() {
		return ties;
	}

	public float getWinning_pct() {
		return winning_pct;
	}

	public int getPoints_for() {
		return points_for;
	}

	public int getPoints_against() {
		return points_against;
	}

	public int getPoint_differential() {
		return point_differential;
	}

	public int getPfpg() {
		return pfpg;
	}

	public int getPapg() {
		return papg;
	}
	
	
	
}
