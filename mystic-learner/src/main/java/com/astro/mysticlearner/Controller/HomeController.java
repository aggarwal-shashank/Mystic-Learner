package com.astro.mysticlearner.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index.html");
		return model;
	}
	@GetMapping("/courses")
	public ModelAndView Courses() {
		ModelAndView model = new ModelAndView();
		model.setViewName("courses.html");
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
}
