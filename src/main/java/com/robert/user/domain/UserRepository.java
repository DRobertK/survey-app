package com.robert.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // FIXME: create custom query using JPQL
    @Query(value = "SELECT u FROM User u WHERE u.role = 0")
    List<User> findAllAdminUsers();

//    // TODO: create custom native query
//    @Query(value = "SELECT * FROM user", nativeQuery = true)
//    List<User> findAllOperatorUsers();
//
//    // TODO: find sorted users
//    @Query(value = "SELECT * FROM user ORDER BY name")
//    List<User> findUsersSorted();
//
//    // TODO: find surveys by user id
//    @Query (value = "SELECT * FROM user ORDER BY id")
//    List<Survey> findSurveysByUserId();
}
