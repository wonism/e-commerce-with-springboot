package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.User;
import demo.service.UserManager;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserManager userManager;
	
	// http://localhost:8080/user/get/2
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public User get(@PathVariable Long id) {
		return userManager.get(id);
	}
	
    // http://localhost:8080/user/save.do?username=홍길동
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public User add(User user) {
		return userManager.save(user);
	}
	
	// http://localhost:8080/user/save/박길동
	@RequestMapping(value="/save/{username}", method=RequestMethod.GET)
	public User add2(@PathVariable String username) {
		return userManager.save(new User(username));
	}		
	
	// http://localhost:8080/user/delete/2
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public void delete(@PathVariable Long id) {
		userManager.delete(id);
	}
}
