package com.astro.mysticlearner.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.astro.mysticlearner.Model.CustomUserDetails;
import com.astro.mysticlearner.Model.Users;
import com.astro.mysticlearner.Repository.UsersRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UsersRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { try { Users user=
	  userRepo.findUserByEmail(username).orElse(null); 
	  if(user == null) { throw new
	  UsernameNotFoundException("User with this Email not found"); } 
	  else { return
	  new CustomUserDetails(user); }
	  
	  
	  } catch(Exception e){ e.printStackTrace(); }
	 
	  return null; }

}
