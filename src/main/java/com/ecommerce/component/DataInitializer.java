package com.ecommerce.component;

import com.ecommerce.model.AppUser;
import com.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            AppUser admin = new AppUser("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN");
            userRepository.save(admin);

            AppUser user = new AppUser("user", passwordEncoder.encode("user123"), "ROLE_USER");
            userRepository.save(user);

            System.out.println("Sample users created: ");
            System.out.println("Admin -> Username: admin, Password: admin123");
            System.out.println("User -> Username: user, Password: user123");
        }
    }
}
