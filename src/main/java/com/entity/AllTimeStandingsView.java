package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// The table is the View !!!!!!
// A new table will be created if db is dropped and rebuilt.
// Otherwise, it's looking at the view
@Table(name="vw_all_time_standings")
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
	
	@Column(name="winningpct", nullable=false)
	private float winningpct;
	
	@Column(name="pointsfor", nullable=false)
	private float pointsfor;
	
	@Column(name="pointsagainst", nullable=false)
	private float pointsagainst;
	
	@Column(name="pointdifferential", nullable=false)
	private float pointdifferential;
	
	@Column(name="pfpg", nullable=false)
	private float pfpg;
	
	@Column(name="papg", nullable=false)
	private float papg;
	
	@Column(name="ppgdiff", nullable=false)
	private float ppgdiff;

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

	public float getWinningpct() {
		return winningpct;
	}

	public float getPointsfor() {
		return pointsfor;
	}

	public float getPointsagainst() {
		return pointsagainst;
	}

	public float getPointdifferential() {
		return pointdifferential;
	}

	public float getPfpg() {
		return pfpg;
	}

	public float getPapg() {
		return papg;
	}

	public float getPpgdiff() {
		return ppgdiff;
	}
	
}
