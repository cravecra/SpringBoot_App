package com.example.demo.account;

//This class is only used for update visualization 
//Every interaction with the Account class will respond with the User affected
//and the state field with the change ex. "Deleted, Added, Previous, New"

public class AccountState {

	private String id;
	private String userid;
	private String name;
	private String currency;
	private String state;

	public AccountState() {

	}

	public AccountState(String id, String userid, String name, String currency, String state) {
		super();
		this.id = id;
		this.setUserid(userid);
		this.name = name;
		this.currency = currency;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
