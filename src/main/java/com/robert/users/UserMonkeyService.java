package com.robert.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMonkeyService {

    private UserMonkeyRepository userMonkeyRepository;

    @Autowired
    public UserMonkeyService(UserMonkeyRepository userMonkeyRepository) {
        this.userMonkeyRepository = userMonkeyRepository;
    }

    public UserMonkey save(UserMonkey userMonkey) {
        return userMonkeyRepository.save(userMonkey);
    }

    public List<UserMonkey> findAll() {
        return userMonkeyRepository.findAll();
    }

    public UserMonkey findById(Long id) {
        return userMonkeyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public UserMonkey update(UserMonkey userMonkey) {
        return userMonkeyRepository.save(userMonkey);
    }

    public void deleteById(Long id) {
        userMonkeyRepository.deleteById(id);
    }
}
