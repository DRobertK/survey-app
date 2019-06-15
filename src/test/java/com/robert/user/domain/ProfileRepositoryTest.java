package com.robert.user.domain;

import com.robert.util.UserFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProfileRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private String firstName1;
    private String firstName2;

    @Test
    public void givenUser_whenCreateUser_thenOk() {
        userRepository.save(UserFactory.createFullProfile());
        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    public void givenAdminUser_whenFindAllAdminUser_thenOk() {
        Profile profile = UserFactory.createFullProfile();

        userRepository.save(profile);
        assertThat(userRepository.findAllAdminUsers().get(0)).isEqualTo(profile);
    }

    @Test
    public void findAllOperatorUsers() {
        Profile viewer = UserFactory.createFullProfile();
        viewer.setFirstName("gigi");

        Profile admin = UserFactory.createFullProfile();
        admin.setFirstName("alex");

        userRepository.saveAll(Arrays.asList(admin, viewer));
        userRepository.findAllOperatorUsers();
    }

    @Test
    public void findAllOperatorAdmin() {
        Profile viewer = UserFactory.createFullProfile();
        viewer.setFirstName("gigi");

        Profile admin = UserFactory.createFullProfile();
        admin.setFirstName("alex");

        userRepository.saveAll(Arrays.asList(admin, viewer));
        userRepository.findAllAdminUsers();
    }

    @Test
    public void findAllAdminUsersSorted() {
        Profile viewer = UserFactory.createFullProfile();
        viewer.setFirstName("gigi");

        Profile admin1 = UserFactory.createFullProfile();
        String firstName1 = "robert";
        admin1.setFirstName(firstName1);

        Profile admin2 = UserFactory.createFullProfile();
        String firstName2 = "alex";
        admin2.setFirstName(firstName2);

        userRepository.saveAll(Arrays.asList(viewer, admin1, admin2));

        List<Profile> sortedList = userRepository.findAdminUsersSorted();

        assertThat(sortedList.size()).isEqualTo(3);
        assertThat(sortedList.get(0).getFirstName()).isEqualTo(firstName2);
        assertThat(sortedList.get(1).getFirstName()).isEqualTo(firstName1);
    }
}