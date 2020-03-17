package com.example.demo.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.elastic.repository.UserSearchRepository;
import com.example.demo.service.UserElasticService;

@Service
public class UserElasticServiceImpl implements UserElasticService {

	Logger log =LoggerFactory.getLogger(UserElasticServiceImpl.class);
	
	@Autowired
	private UserSearchRepository userElasticRepository;
	
	@Override
	public User save(User user) {
		log.debug("Elastic Service to save User {} ",user);
		return userElasticRepository.save(user);
	}

	@Override
	public Optional<User> findById(String id) {
		log.debug("Elastic Service to get user by id {} ",id);
		return userElasticRepository.findById(id);
	}

}
