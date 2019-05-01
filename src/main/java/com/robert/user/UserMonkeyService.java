package com.robert.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserMonkeyService {

    private UserMonkeyRepository userMonkeyRepository;

    @Autowired
    public UserMonkeyService(UserMonkeyRepository userMonkeyRepository) {
        this.userMonkeyRepository = userMonkeyRepository;
    }

    @Transactional
    public UserMonkey save(UserMonkey userMonkey) {
        return userMonkeyRepository.save(userMonkey);
    }

    public List<UserMonkey> findAll() {
        return userMonkeyRepository.findAll();
    }

    public UserMonkey findById(Long id) {
        return userMonkeyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
    }

    public void deleteById(Long id) {
        userMonkeyRepository.deleteById(id);
    }
}
