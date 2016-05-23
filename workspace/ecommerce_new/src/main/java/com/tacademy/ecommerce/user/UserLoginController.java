package com.tacademy.ecommerce.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserLoginController {

	
	  @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
	  public String index() {
		  //유저 프로덕트 리스트로 이동해야함.
	    return "redirect:/user/product/list";
	  }
	
	  @RequestMapping(value = "/user/login", method = RequestMethod.GET)
	  public String login() {
		  
	    return "user/login-form";
	  }
	  
	  @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	  public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null)
	      session.invalidate();
	    SecurityContextHolder.clearContext();
	    return "user/login-form";
	  }
}
