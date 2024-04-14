package com.astro.mysticlearner.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity(name="roles")

public class Role {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id;

	 @Column(nullable=false,unique=true)
	 private String name;
	 
	 @ManyToMany(mappedBy="roles")
	 private List<Users> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	 
	 
	 
}


