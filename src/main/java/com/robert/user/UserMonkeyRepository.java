package com.robert.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMonkeyRepository extends JpaRepository<UserMonkey, Long> {

    // TODO: use spring syntax to find by first name
    UserMonkey findByFirstName();

    // TODO: use jpa @Query to find by last name
    UserMonkey findByLastName();
}
