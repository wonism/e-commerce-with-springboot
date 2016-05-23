package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.User;
import demo.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User get(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
