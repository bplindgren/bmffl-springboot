package com.entity;


public class NewEntry {
	public String title;
	public String content;
	public long userId;
	
	public NewEntry () {}
	
	public NewEntry(String title, String content, long userId) {
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
