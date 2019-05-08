package com.robert.user.domain;

import com.robert.util.UserFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUser_whenCreateUser_thenOk() {
        userRepository.save(UserFactory.createFullUser());
        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    public void givenAdminUser_whenFindAllAdminUser_thenOk() {
        User user = UserFactory.createFullUser();
        user.setRole(Role.ADMIN);

        userRepository.save(user);
        assertThat(userRepository.findAllAdminUsers().get(0)).isEqualTo(user);
    }

}