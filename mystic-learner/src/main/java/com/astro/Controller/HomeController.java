package com.astro.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/admin")
	public ModelAndView adminlist() {
		ModelAndView model = new ModelAndView();
		return model;
	}

}
