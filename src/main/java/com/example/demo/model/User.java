package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User 
{

	private String username;
	@Id
	private String userid;
	@Transient
	List<Contact> contactlist=new ArrayList<Contact>();
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "aid", nullable = false) private Alien alien;
	 * 
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	 

	public List<Contact> getContactlist() {
		return contactlist;
	}
	public void setContactlist(List<Contact> contactlist) {
		this.contactlist = contactlist;
	}
	/*
	 * public Alien getAlien() { return alien; } public void setAlien(Alien alien) {
	 * this.alien = alien; }
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", userid=" + userid + ", contactlist=" + contactlist + "]";
	}
	
	
	
	
	
	
	
}
