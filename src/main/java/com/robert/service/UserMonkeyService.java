package com.robert.service;

import com.robert.UserMonkey;
import com.robert.UserMonkeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMonkeyService implements UserMonkeyServiceImpl {

    private UserMonkeyRepository userMonkeyRepository;

    @Autowired
    public UserMonkeyService(UserMonkeyRepository userMonkeyRepository) {
        this.userMonkeyRepository = userMonkeyRepository;
    }

    @Override
    public UserMonkey save(UserMonkey userMonkey) {
        return userMonkeyRepository.save(userMonkey);
    }

    @Override
    public List<UserMonkey> findAll() {
        return userMonkeyRepository.findAll();
    }

    @Override
    public UserMonkey findById(Long id) {
        return userMonkeyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public UserMonkey update(UserMonkey userMonkey) {
        return userMonkeyRepository.save(userMonkey);
    }

    @Override
    public void deleteById(Long id) {
        userMonkeyRepository.deleteById(id);
    }
}
