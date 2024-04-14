package com.astro.mysticlearner.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.astro.mysticlearner.Model.Role;
import com.astro.mysticlearner.Model.Users;
import com.astro.mysticlearner.Repository.RoleRepository;
import com.astro.mysticlearner.Repository.UsersRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {
	
	@Autowired
	private UsersRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public ModelAndView Login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login.html");
		return model;
	}

	@GetMapping("/register")
	public ModelAndView Register() {
		ModelAndView model = new ModelAndView();
		model.setViewName("register.html");
		return model;
	}
	
	@PostMapping("/register")
	public ModelAndView RegisterPost(@ModelAttribute("user")Users user){
		ModelAndView model = new ModelAndView();
		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		List<Role> role= new ArrayList<>();
		role.add(roleRepo.findById(2).get());
		user.setRoles(role);
		userRepo.save(user);
		
		model.setViewName("redirect:/login");
		return model;
	
	}

}
