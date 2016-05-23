package com.tacademy.ecommerce.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLoginController {

  @RequestMapping(value = {"/", "/admin"}, method = RequestMethod.GET)
  public String index() {
    return "redirect:/admin/product/list";
  }

  @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
  public String login() {
    return "login";
  }

  @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null)
      session.invalidate();
    SecurityContextHolder.clearContext();
    return "login";
  }

}
