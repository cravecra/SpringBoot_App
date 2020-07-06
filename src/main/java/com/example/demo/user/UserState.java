package com.example.demo.user;

import java.util.List;

import com.example.demo.account.Account;

public class UserState {

	private String id;
	private String name;
	private List<Account> accounts;
	private String state;

	public UserState() {

	}

	public UserState(String id, String name, List<Account> accounts, String state) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
		this.state = state;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
