package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiRequestException;

// UserService Class for communication between user input and outputs

// Control of possible user errors for a better understand
// via JSON so User can see what are the errors
// due logic has been done focused on URL input fields and autogenerated values

@Service
public class UserService {
	private String handledException = "Handled Exception Occurred: ";

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsersFull() {
		List<User> users = userRepository.findAll();
		if (!users.isEmpty()) {
			return userRepository.findAll();
		} else {
			throw new ApiRequestException(handledException + "Users NOT FOUNDED or DB with 0 Users");
		}
	}

	public List<SimpleUser> getAllUsers() {
		List<SimpleUser> users = userRepository.getSimpleUsers();
		if (!users.isEmpty()) {
			return users;
		} else {
			throw new ApiRequestException(handledException + "Users NOT FOUNDED or DB with 0 Users");
		}
	}

	public User getUser(String id) {

		return userRepository.findById(id).map(user -> user)
				.orElseThrow(() -> new ApiRequestException(handledException + "Users ID: " + id + " NOT FOUNDED"));
	}

	public List<UserState> addUsers(List<User> users) {
		List<UserState> usersAdded = new ArrayList<UserState>();
		users.forEach(user -> {
			if (user.getAccounts() != null) {
				user.getAccounts().forEach(account -> {
					if (account.getUserid() != null) {
						throw new ApiRequestException(handledException
								+ "Please remove userId property from account id:" + account.getId() + " userid:"
								+ account.getUserid() + " name:" + account.getName() + " currency:"
								+ account.getCurrency()
								+ ", ID will be taken from URL ./users/{id}/");
					}
					if (account.getId() != null) {
						throw new ApiRequestException(handledException + "Please remove ID property from account id:"
								+ account.getId() + " userid:" + account.getUserid() + " name:" + account.getName()
								+ " currency:" + account.getCurrency()
								+ ", ID will be autogenerated or do a PUT request to update account in ./users/{userid}/accounts/{id}");
						
					}
				});
			}
			if (user.getId() != null)
				throw new ApiRequestException(handledException + "Please remove ID property from user id:"
						+ user.getId() + " name:" + user.getName() + " accounts:" + user.getAccounts()
						+ ", ID will be autogeneratd or do a PUT request to update user in ./users/{userid}");
		});

		users.forEach(user -> {
			User usr = userRepository.save(user);
			usr.getAccounts().forEach(account -> account.setUserid(usr.getId()));
			usersAdded.add(new UserState(usr.getId(), usr.getName(), usr.getAccounts(), "ADDED"));
		});

		return usersAdded;
	}

	public List<UserState> updateUser(User user, String id) {
		List<UserState> iterations = new ArrayList<UserState>();
		if (user.getAccounts() != null) {
			throw new ApiRequestException(handledException
					+ "Please remove User Accounts property, update only possible for a single Account from ./users/{userid}/accounts/{id}");
		}
		if (user.getId() != null) {
			throw new ApiRequestException(
					handledException + "Please remove User ID property it will be taken from the URL ./users/{userid}");
		}
		user.setId(id);
		return userRepository.findById(user.getId()).map(usr -> {
			if(!usr.getName().equals(user.getName())) {
			iterations.add(new UserState(usr.getId(), usr.getName(), usr.getAccounts(), "Previous"));
			usr.setName(user.getName());
			iterations.add(new UserState(usr.getId(), usr.getName(), usr.getAccounts(), "New"));
			return iterations;
			} else {
				throw new ApiRequestException(handledException + "New Values are the same in Database, UPDATE NOT DONE");
			}
		}).orElseThrow(() -> new ApiRequestException(handledException + "User ID: " + user.getId() + " NOT FOUNDED"));

	}

	public UserState deleteUser(String id) {
		return userRepository.findById(id).map(user -> {
			userRepository.deleteById(user.getId());
			return new UserState(user.getId(), user.getName(), user.getAccounts(), "DELETED");
		}).orElseThrow(() -> new ApiRequestException(handledException + "Users ID: " + id + " NOT FOUNDED"));
	}

}
