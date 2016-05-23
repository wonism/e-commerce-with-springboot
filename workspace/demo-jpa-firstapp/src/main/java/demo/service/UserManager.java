package demo.service;

import demo.domain.User;

public interface UserManager {
	User get(Long id);
	User save(User user);
	void delete(Long id);
}
