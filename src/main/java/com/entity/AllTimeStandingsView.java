package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// The table is the View !!!!!!
// A new table will be created if db is dropped and rebuilt.
// Otherwise, it's looking at the view
@Table(name="all_time_standings_view")
// The response from the API creates this object
public class AllTimeStandingsView {

	@Id
	@Column(name="ownerId", nullable=false)
	private int ownerId;
	
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
	
	@Column(name="winningPct", nullable=false)
	private float winningPct;
	
	@Column(name="pointsFor", nullable=false)
	private float pointsFor;
	
	@Column(name="pointsAgainst", nullable=false)
	private float pointsAgainst;
	
	@Column(name="pointDifferential", nullable=false)
	private float pointDifferential;
	
	@Column(name="pfpg", nullable=false)
	private float pfpg;
	
	@Column(name="papg", nullable=false)
	private float papg;

	public int getOwnerId() {
		return ownerId;
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

	public float getWinningPct() {
		return winningPct;
	}

	public float getPointsFor() {
		return pointsFor;
	}

	public float getPointsAgainst() {
		return pointsAgainst;
	}

	public float getPointDifferential() {
		return pointDifferential;
	}

	public float getPfpg() {
		return pfpg;
	}

	public float getPapg() {
		return papg;
	}
	
	
	
}
