package com.robert;

import com.robert.user.domain.User;
import com.robert.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonkeyApp {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MonkeyApp.class);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            userRepository.save(
                    new User("gigi", "san",
                            "gigi@gmail.com", "bucharest", "romania"));
        };
    }
}
