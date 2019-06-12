package com.robert.user;

import com.robert.user.domain.Profile;
import com.robert.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Profile save(Profile profile) {
        return userRepository.save(profile);
    }

    public List<Profile> findAll() {
        return userRepository.findAll();
    }

    public Profile findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
