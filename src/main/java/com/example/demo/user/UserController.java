package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiRequestException;

// User Controller used to execute GET, POST, PUT, DELETE Methods throw API
// All Methods has their respective try catch for error control

//There are two Methods for get Users, to visualize a simple form of the users from ./users
//And Second the full view with its corresponding accounts from /usersfull

@RestController
public class UserController {
	private String handledException = "Handled Exception Occurred: ";
	private String notHandledException = "Exception Occurred: ";

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/usersfull")
	public List<User> getAllUsersFull() {
		try {
			return userService.getAllUsersFull();
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<SimpleUser> getAllUsers() {
		try {
			return userService.getAllUsers();
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public User getUser(@PathVariable String id) {
		try {
			return userService.getUser(id);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public List<UserState> addUsers(@RequestBody List<User> users) {
		try {
			return userService.addUsers(users);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public List<UserState> updateUser(@RequestBody User user, @PathVariable String id) {
		try {
			return userService.updateUser(user, id);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public UserState deleteUser(@PathVariable String id) {
		try {
			return userService.deleteUser(id);
		} catch (Exception ex) {
			throw new ApiRequestException(isHandledException(ex.getMessage()), ex);
		}
	}

	private String isHandledException(String msg) {
		return (msg.startsWith(handledException)) ? msg.replaceFirst(handledException, "") : notHandledException + msg;
	}

}
