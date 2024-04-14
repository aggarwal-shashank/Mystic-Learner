package com.astro.mysticlearner.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astro.mysticlearner.Model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	Optional<Users>findUserByEmail(String email);

}
