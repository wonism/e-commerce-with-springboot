package com.tacademy.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	@RequestMapping(value={"/"})
	public RedirectView main() {
		return new RedirectView("/home");
	}
	
	@RequestMapping(value={"/home"})
	public String home() {
		return "home";
	}
}
