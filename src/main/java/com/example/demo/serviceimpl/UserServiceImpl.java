package com.example.demo.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;




@Service
public class UserServiceImpl implements UserService{

	Logger log =LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		log.debug("Service to save User {} ",user);
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(String id) {
		log.debug("Service to get user by id {} ",id);
		return userRepository.findById(id);
	}

	
}
