package com.tacademy.ecommerce.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.Authority;
import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.exception.UserNotFoundException;
import com.tacademy.ecommerce.exception.UserPasswordNotMatchedException;
import com.tacademy.ecommerce.exception.UsernameExistException;
import com.tacademy.ecommerce.security.Authorities;
import com.tacademy.ecommerce.service.UserManager;
import com.tacademy.ecommerce.util.ParameterUtil;

@RestController
public class UserController {

  @Autowired
  private UserManager userManager;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @RequestMapping(value = "/join", method = RequestMethod.POST)
  public ResponseVO join(User user) {
    ParameterUtil.checkParameterEmpty(user.getUsername(), user.getPassword(), user.getName());
    checkUsernameDuplicated(user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    Authority authority = userManager.findByAuthority(Authorities.USER);
    user.getAuthorities().add(authority);
    userManager.save(user);

    return ResponseVO.ok();
  }

  private void checkUsernameDuplicated(String username) {
    boolean existUsername = userManager.existUserByUsername(username);
    if (existUsername)
      throw new UsernameExistException();
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseVO login(@RequestParam String username, @RequestParam String password) {

	System.out.println("## UserController Login ##");
    User user = userManager.findByUsername(username);
    if (user == null)
      throw new UserNotFoundException();

    if (!passwordEncoder.matches(password, user.getPassword()))
      throw new UserPasswordNotMatchedException();

    SecurityContextHolder.getContext().setAuthentication(
        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));

    return ResponseVO.ok();
  }

  @RequestMapping(value = "/logout")
  public ResponseVO logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null)
      session.invalidate();
    SecurityContextHolder.clearContext();
    return ResponseVO.ok();
  }

}
