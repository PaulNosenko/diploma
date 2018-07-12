package diploma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import diploma.entity.User;
import diploma.enums.Role;
import diploma.repository.ProductRepository;
import diploma.repository.UserProductRepository;
import diploma.repository.UserRepository;

@SpringBootApplication
public class DiplomaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomaApplication.class, args);
	}

	@Autowired
	UserRepository userDao;

	@Autowired
	ProductRepository productDao;

	@Autowired
	UserProductRepository userProductDao;

	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setEmail("pavel@gmail.com");
		user.setPassword(passwordEncoder.encode("1234567"));
		user.setRole(Role.ROLE_ADMIN);

		User find = userRepository.findByEmail("pavel@gmail.com");
		if (find == null) {
			userRepository.save(user);
		}

	}

}
