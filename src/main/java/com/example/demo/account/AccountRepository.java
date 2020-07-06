package com.example.demo.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String>{
	
	public Optional<List<Account>> findByUserid(String userid);

}
