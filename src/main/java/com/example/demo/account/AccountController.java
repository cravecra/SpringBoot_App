package com.example.demo.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiRequestException;

// Account Controller used to execute GET, POST, PUT, DELETE Methods throw API
// All Methods has their respective try catch for error control

@RestController
public class AccountController {
	private String handledException = "Handled Exception Occurred: ";
	private String notHandledException = "Exception Occurred: ";

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userid}/accounts")
	public List<Account> getAllAccounts(@PathVariable String userid) {
		try {
			return accountService.getAllAccounts(userid);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userid}/accounts/{id}")
	public Account getAccount(@PathVariable String userid, @PathVariable String id) {
		try {
			return accountService.getAccount(userid, id);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/{userid}/accounts")
	public List<AccountState> addAccounts(@RequestBody List<Account> accounts, @PathVariable String userid) {
		try {
			return accountService.addAccounts(accounts, userid);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userid}/accounts/{id}")
	public List<AccountState> updateAccount(@RequestBody Account account, @PathVariable String userid, @PathVariable String id) {
		try {
			return accountService.updateAccount(account, userid, id);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userid}/accounts/{id}")
	public AccountState deleteAccount(@PathVariable String userid, @PathVariable String id) {
		try {
			return accountService.deleteAccount(userid, id);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	private String isHandledException(String msg) {
		return (msg.startsWith(handledException)) ? msg.replaceFirst(handledException, "") : notHandledException + msg;
	}

}
