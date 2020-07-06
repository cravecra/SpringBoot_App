package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT new com.example.demo.user.SimpleUser(u.id, u.name) FROM User u")
	public List<SimpleUser> getSimpleUsers();
}
