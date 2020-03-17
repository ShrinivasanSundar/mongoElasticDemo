package com.example.demo.service;

import java.util.Optional;

import com.example.demo.domain.User;

public interface UserElasticService {

	User save (User user);
	
	Optional<User> findById(String id);
}
