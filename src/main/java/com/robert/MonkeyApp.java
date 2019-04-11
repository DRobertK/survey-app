package com.robert;

import com.robert.users.UserMonkey;
import com.robert.users.UserMonkeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonkeyApp {

    @Autowired
    private UserMonkeyRepository userMonkeyRepository;

    public static void main(String[] args) {
        SpringApplication.run(MonkeyApp.class);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            userMonkeyRepository.save(
                    new UserMonkey("gigi", "san",
                            "gigi@gmail.com", "bucharest", "romania"));
        };
    }
}
