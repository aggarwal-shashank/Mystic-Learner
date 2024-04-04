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

}
