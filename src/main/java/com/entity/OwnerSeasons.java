package com.entity;

import java.util.List;

public class OwnerSeasons {
	
	private String ownerName;
	private List<String> seasons;
	
	public OwnerSeasons(String ownerName, List<String> seasons) {
		this.ownerName = ownerName;
		this.seasons = seasons;
	}
	
}
