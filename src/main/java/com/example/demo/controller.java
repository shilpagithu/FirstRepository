package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Repo.AlienRepo;
import com.example.demo.model.Alien;

@RestController
@RequestMapping("/")
public class controller 
{
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	} 
	@PostMapping("/addAlien")
	public Alien addAlien(@RequestBody Alien alian)
	{
		repo.save(alian);
		return alian;
	}
	
	@GetMapping("/getAlien")
	public List<Alien> view()
	{
		List<Alien> alien=(List<Alien>) repo.findAll();
		ModelAndView model=new  ModelAndView();
		model.addObject("alien", alien);
		model.setViewName("index.jsp");
		return alien;
	}
	@GetMapping("/userpath/{aid}")
	public String updateuser(@PathVariable("aid") String aid)
	{
		System.out.println("==============take id from url and update data "+aid);
		Optional<Alien> alien1=repo.findById(aid);
		Alien alien=alien1.get();
		alien.setAname("ajit");
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/userparam")
	public String updatuser1(@RequestParam("val") String aid)
	{
		System.out.println("==============take id from page parameter and update data "+aid);
		Optional<Alien> alien1=repo.findById(aid);
		Alien alien=alien1.get();
		alien.setAname("Karishma");
		repo.save(alien);
		return "home.jsp";
	}
	@PutMapping("/updateAlien")
	public List<Alien> update()
	{
		Optional<Alien> alienid=repo.findById("aid");
		Alien alien=alienid.get();
		alien.setAname("sss");
		repo.save(alien);
		ModelAndView model=new  ModelAndView();
		model.addObject("alienid", alien);
		model.setViewName("home.jsp");
		return (List<Alien>) alien;
	}
	
	@RequestMapping("/deleteAlien")
	public String delete()
	{
		Iterable<Alien> alien=repo.findAll();
		alien.forEach(user->System.out.println(user));
		//repo.deleteAll(alien);
		repo.deleteById("aid");
		return "home.jsp";
	}
	@GetMapping("/getget")
	public List<Alien> getget()
	{
		List<Alien> alien=(List<Alien>) repo.findAll();
		//alien.forEach(user->System.out.println(user));
		System.out.println("======="+alien);
		return alien;
	}
	@PostMapping("/postpost")
	public Alien postpost(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
}
