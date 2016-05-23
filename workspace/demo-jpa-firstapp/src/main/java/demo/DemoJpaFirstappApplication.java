package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.User;
import demo.repository.UserRepository;

@SpringBootApplication
public class DemoJpaFirstappApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaFirstappApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepository;
	
	public void run(String...args) {
		userRepository.save(new User("1길동"));
		userRepository.save(new User("2길동"));
		userRepository.save(new User("3길동"));
	}	
}
