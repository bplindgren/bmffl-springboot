package com.entity;

public class MatchupRecords {
	
	private Record awayRecord;
	private Record homeRecord;
	
	public MatchupRecords(Record awayRecord, Record homeRecord) {
		this.awayRecord = awayRecord;
		this.homeRecord = homeRecord;
	}

	public Record getAwayRecord() {
		return awayRecord;
	}

	public void setAwayRecord(Record awayRecord) {
		this.awayRecord = awayRecord;
	}

	public Record getHomeRecord() {
		return homeRecord;
	}

	public void setHomeRecord(Record homeRecord) {
		this.homeRecord = homeRecord;
	}	
	
}
