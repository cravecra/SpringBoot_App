package com.example.demo.user;

// This class is only used for simple visualization 
// User without accounts

public class SimpleUser {

	private String id;
	private String name;

	public SimpleUser() {

	}
	
	public SimpleUser(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
