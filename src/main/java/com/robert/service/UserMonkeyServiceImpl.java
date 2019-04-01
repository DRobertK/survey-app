package com.robert.service;

import com.robert.UserMonkey;

import java.util.List;

public interface UserMonkeyServiceImpl {

    UserMonkey save(UserMonkey userMonkey);

    List<UserMonkey> findAll();

    UserMonkey findById(Long id);

    UserMonkey update(UserMonkey userMonkey);

    void deleteById(Long id);


}
