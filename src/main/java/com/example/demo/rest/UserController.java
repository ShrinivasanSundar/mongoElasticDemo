package com.example.demo.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.example.demo.domain.User;
import com.example.demo.service.UserElasticService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

			
	@Autowired
	private UserService userService;

	@Autowired
	private UserElasticService userElasticService;
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/user")
	@Timed
	public ResponseEntity<?> save(@RequestBody User user) {
		log.debug("REST request to save user {} ",user);
		User savedUser = userService.save(user);
		User elasticUser=userElasticService.save(user);
		UserResponse userResponse=new UserResponse();
		userResponse.setElasticId(elasticUser.getId());
		userResponse.setMongoId(savedUser.getId());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user")
	@Timed
	public ResponseEntity<?> getUserById(@RequestParam String id){
		log.debug("REST request to get  user by {} ",id);
		Optional<User> userOpt=userService.findById(id);
		if(userOpt.isPresent()) {
			User user= userOpt.get();
			return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("No user present",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/search/user")
	@Timed
	public ResponseEntity<?> getElasticUserById(@RequestParam String id){
		log.debug("REST request to search user by id {} ",id);
		Optional<User> userOpt=userElasticService.findById(id);
		if(userOpt.isPresent()) {
			User user= userOpt.get();
			return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("No user present",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/find/user/{id}")
	@Timed
	public ResponseEntity<?> getElasticUserByIdByPath(@PathVariable String id){
		log.debug("REST request to search user by id {} ",id);
		Optional<User> userOpt=userElasticService.findById(id);
		if(userOpt.isPresent()) {
			User user= userOpt.get();
			return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("No user present",HttpStatus.BAD_REQUEST);
		}
	}
}
