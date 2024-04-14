package com.astro.mysticlearner.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.astro.mysticlearner.Repository.CoursesRepository;
import com.astro.mysticlearner.Repository.LessonsRepository;
import com.astro.mysticlearner.Model.Courses;
import com.astro.mysticlearner.Model.Lessons;

@RestController
public class HomeController {
	@Autowired
	private CoursesRepository courseRepo;
	@Autowired
	private LessonsRepository lessonRepo;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		List<Courses> courses= courseRepo.findAll();
		if(courses.size()>6)
		{
			model.addObject("courses",courses.subList(0, 6));
		}
		else
		model.addObject("courses",courses);
		model.setViewName("index.html");
		return model;
	}
	@GetMapping("/courses")
	public ModelAndView Courses() {
		ModelAndView model = new ModelAndView();
		List<Courses> courses= courseRepo.findAll();
	
		model.addObject("courses",courses);
		model.setViewName("courses.html");
		return model;
	}
	
	@GetMapping("/course/{id}")
	public ModelAndView Courses(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
	      Courses courses= courseRepo.findById(id).orElse(null);
	    if(courses!=null)
		{
	    	List<Lessons> lessons=lessonRepo.findByCourse(courses);
	    	model.addObject("lessons",lessons);
	    model.addObject("course",courses);
		model.setViewName("course-detail.html");}
	    else
	    {
	    	model.setViewName("course-not-found.html");
	    }
		return model;
	}
	@GetMapping("/about-us")
	public ModelAndView AboutUs() {
		ModelAndView model = new ModelAndView();
		model.setViewName("about-us.html");
		return model;
	}
	@GetMapping("/shopping")
	public ModelAndView Shopping() {
		ModelAndView model = new ModelAndView();
		model.setViewName("shopping.html");
		return model;
	}

	@GetMapping("/lecture/{id}")
	public ModelAndView Lecture(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(!name.equals("anonymousUser"))
		{
		
	    Lessons lessons=lessonRepo.findById(id).orElse(null);
	    	model.addObject("lesson",lessons);
		model.setViewName("course-detail.html");
		
		}
	    else
	    {
	    	model.setViewName("redirect:/login");
	    }
		return model;
	}
}
