package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_season_stats")
public class SeasonStats {

	@Id
	@Column(name="id", nullable=false)
	public long id;
	
	@Column(name="champion", nullable=false)
	private Boolean champion;
	
	@Column(name="divisionwinner", nullable=false)
	private String divisionwinner;
	
	@Column(name="gamesplayed", nullable=false)
	private int gamesplayed;
	
	@Column(name="losses", nullable=false)
	private int losses;
	
	@Column(name="lossesregseason", nullable=false)
	private int lossesregseason;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="pointsagainst", nullable=false)
	private float pointsagainst;
	
	@Column(name="pointsfor", nullable=false)
	private float pointsfor;
	
	@Column(name="standing", nullable=false)
	private int standing;
	
	@Column(name="ties", nullable=false)
	private int ties;
	
	@Column(name="wins", nullable=false)
	private int wins;
	
	@Column(name="winsregseason", nullable=false)
	private int winsregseason;
	
	@Column(name="year", nullable=false)
	private String year;
	
	@Column(name="owner_id", nullable=false)
	private int ownerId;
	
	@Column(name="winningpct", nullable=false)
	private float winningpct;
	
	@Column(name="pointdifferential", nullable=false)
	private float pointdifferential;
	
	@Column(name="pfpg", nullable=false)
	private float pfpg;
	
	@Column(name="papg", nullable=false)
	private float papg;
	
	@Column(name="ppgdiff", nullable=false)
	private float ppgdiff;
	
	@Column(name="season_id", nullable=false)
	private int seasonId;
	
	@Column(name="division", nullable=false)
	private String division;

	public long getId() {
		return id;
	}

	public Boolean getChampion() {
		return champion;
	}

	public String getDivisionwinner() {
		return divisionwinner;
	}

	public int getGamesplayed() {
		return gamesplayed;
	}

	public int getLosses() {
		return losses;
	}

	public int getLossesregseason() {
		return lossesregseason;
	}

	public String getName() {
		return name;
	}

	public float getPointsagainst() {
		return pointsagainst;
	}

	public float getPointsfor() {
		return pointsfor;
	}

	public int getStanding() {
		return standing;
	}

	public int getTies() {
		return ties;
	}

	public int getWins() {
		return wins;
	}

	public int getWinsregseason() {
		return winsregseason;
	}

	public String getYear() {
		return year;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public float getWinningpct() {
		return winningpct;
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

	public int getSeasonId() {
		return seasonId;
	}

	public String getDivision() {
		return division;
	}
	
}
