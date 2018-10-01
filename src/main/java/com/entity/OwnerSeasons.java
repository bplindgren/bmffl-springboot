package com.entity;

public class OwnerSeasons {
	
	private int ownerId;
	private String firstSeason;
	private String lastSeason;
	
	public OwnerSeasons(int ownerId, String firstSeason, String lastSeason) {
		this.ownerId = ownerId;
		this.firstSeason = firstSeason;
		this.lastSeason = lastSeason;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstSeason() {
		return firstSeason;
	}

	public void setFirstSeason(String firstSeason) {
		this.firstSeason = firstSeason;
	}

	public String getLastSeason() {
		return lastSeason;
	}

	public void setLastSeason(String lastSeason) {
		this.lastSeason = lastSeason;
	}
	
}
