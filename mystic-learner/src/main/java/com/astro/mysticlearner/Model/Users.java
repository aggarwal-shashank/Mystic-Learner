package com.astro.mysticlearner.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;



@Entity
public class Users {
	
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Integer id;

 @Column(nullable=false)
 private String name;

 @Column(nullable=false, unique=true)
 private String email;

 private String password;
 @ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
 @JoinTable(name="user_role",joinColumns= @JoinColumn(name="USER_ID", referencedColumnName="ID"),
		 inverseJoinColumns= @JoinColumn(name="ROLE_ID", referencedColumnName="ID")
		 )
 private List<Role> roles;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
public Users(Users user) {

	this.id = user.id;
	this.name = user.name;
	this.email = user.email;
	this.password = user.password;
	this.roles = user.roles;
}
public Users() {

}
 
 
}
