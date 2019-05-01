package com.robert.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // TODO: use spring syntax to find by first name
    User findByFirstName();

    // TODO: use jpa @Query to find by last name
    User findByLastName();
}
