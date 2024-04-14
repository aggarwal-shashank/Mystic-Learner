package com.astro.mysticlearner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astro.mysticlearner.Model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {


}
