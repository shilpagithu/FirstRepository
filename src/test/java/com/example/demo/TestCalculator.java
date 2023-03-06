package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import com.example.demo.Repo.AlienRepo;
import com.example.demo.model.Alien;

@SpringBootTest
class TestCalculator 
{
	@Autowired
	private AlienRepo repo;
	
	@Test
	@Disabled
	void existsById() 
	{
		/*
		 * Alien alien=new Alien(); alien.setAid("1"); repo.save(alien);
		 */
		Boolean actualresult = repo.existsById("8");
		
		assertThat(actualresult).isTrue();
	}

}
