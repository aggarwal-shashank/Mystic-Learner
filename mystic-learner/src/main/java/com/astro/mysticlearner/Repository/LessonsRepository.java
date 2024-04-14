package com.astro.mysticlearner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astro.mysticlearner.Model.Courses;
import com.astro.mysticlearner.Model.Lessons;

public interface LessonsRepository extends JpaRepository<Lessons, Integer> {

	List<Lessons> findByCourse(Courses course);
}
