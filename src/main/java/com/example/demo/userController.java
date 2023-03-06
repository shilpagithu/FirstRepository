package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repo.AlienRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.exception.CustomException;
import com.example.demo.model.Contact;
import com.example.demo.model.User;

@RestController
@RequestMapping("/")
public class userController 
{
	@Autowired
	UserRepo repo;
	
	@Autowired
	RestTemplate rest;
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<Object> getUser(@PathVariable String uid)
	{
		User user=repo.findById(uid).orElse(null);
		List<Contact> contactlist=rest.getForObject("http://localhost:8092/user/"+uid, List.class);
		if(contactlist.isEmpty())throw new CustomException();
		user.setContactlist(contactlist);
	    return new ResponseEntity<Object>(user, HttpStatus.OK);
	} 
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user)
	{
		repo.save(user);
		return user;
	}
}
