package com.entity;


public class NewEntry {
	public long id;
	public String title;
	public String content;
	public long userId;
	
	public NewEntry () {}
	
	public NewEntry(long id, String title, String content, long userId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

