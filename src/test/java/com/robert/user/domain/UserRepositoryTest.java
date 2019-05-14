package com.robert.user.domain;

import com.robert.util.UserFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;

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

    @Test
    public void findAllOperatorUsers() {
        User viewer = UserFactory.createFullUser();
        viewer.setFirstName("gigi");
        viewer.setRole(Role.VIEWER);

        User admin = UserFactory.createFullUser();
        admin.setFirstName("alex");
        admin.setRole(Role.ADMIN);

        userRepository.saveAll(Arrays.asList(admin, viewer));
        userRepository.findAllOperatorUsers();
    }

}