package com.leocptr.workshopmongo.config;

import com.leocptr.workshopmongo.domain.User;
import com.leocptr.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User user1 = new User(null, "Maria Eduarda Corrá", "maria@gmail.com");
        User user2 = new User(null, "Rafael Corrá", "rafael@gmail.com");
        User user3 = new User(null, "Bianca Corrá", "bianca@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
