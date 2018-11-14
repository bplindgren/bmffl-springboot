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
	public Integer id;
	
	@Column(name="champion", nullable=false)
	private String champion;
	
	@Column(name="divisionwinner", nullable=false)
	private String divisionwinner;
	
	@Column(name="gamesplayed", nullable=false)
	private Integer gamesplayed;
	
	@Column(name="losses", nullable=false)
	private Integer losses;
	
	@Column(name="lossesregseason", nullable=false)
	private Integer lossesregseason;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="pointsagainst", nullable=false)
	private Float pointsagainst;
	
	@Column(name="pointsfor", nullable=false)
	private Float pointsfor;
	
	@Column(name="standing", nullable=false)
	private Integer standing;
	
	@Column(name="ties", nullable=false)
	private Integer ties;
	
	@Column(name="wins", nullable=false)
	private Integer wins;
	
	@Column(name="winsregseason", nullable=false)
	private Integer winsregseason;
	
	@Column(name="year", nullable=false)
	private String year;
	
	@Column(name="owner_id", nullable=false)
	private Integer ownerId;
	
	@Column(name="winningpct", nullable=false)
	private Float winningpct;
	
	@Column(name="pointdifferential", nullable=false)
	private Float pointdifferential;
	
	@Column(name="pfpg", nullable=false)
	private Float pfpg;
	
	@Column(name="papg", nullable=false)
	private Float papg;
	
	@Column(name="ppgdiff", nullable=false)
	private Float ppgdiff;
	
	@Column(name="season_id", nullable=false)
	private Integer seasonId;
	
	@Column(name="division", nullable=false)
	private String division;

	public Integer getId() {
		return id;
	}

	public String getChampion() {
		return champion;
	}

	public String getDivisionwinner() {
		return divisionwinner;
	}

	public Integer getGamesplayed() {
		return gamesplayed;
	}

	public Integer getLosses() {
		return losses;
	}

	public Integer getLossesregseason() {
		return lossesregseason;
	}

	public String getName() {
		return name;
	}

	public Float getPointsagainst() {
		return pointsagainst;
	}

	public Float getPointsfor() {
		return pointsfor;
	}

	public Integer getStanding() {
		return standing;
	}

	public Integer getTies() {
		return ties;
	}

	public Integer getWins() {
		return wins;
	}

	public Integer getWinsregseason() {
		return winsregseason;
	}

	public String getYear() {
		return year;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Float getWinningpct() {
		return winningpct;
	}

	public Float getPointdifferential() {
		return pointdifferential;
	}

	public Float getPfpg() {
		return pfpg;
	}

	public Float getPapg() {
		return papg;
	}

	public Float getPpgdiff() {
		return ppgdiff;
	}

	public Integer getSeasonId() {
		return seasonId;
	}
	
	public String getDivision() {
		return division;
	}
	
}
