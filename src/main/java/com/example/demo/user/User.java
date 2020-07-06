package com.example.demo.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.demo.account.Account;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	private String name;
	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private List<Account> accounts;

	public User() {

	}

	public User(String id, String name, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
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

}
