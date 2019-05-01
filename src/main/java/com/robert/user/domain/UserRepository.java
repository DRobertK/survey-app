package com.robert.user.domain;

import com.robert.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // FIXME: create custom query using JPQL
//    @Query
    List<User> findAllAdminUsers();

    // TODO: create custom native query
//    @Query
    List<User> findAllOperatorUsers();

    // TODO: find sorted users
    @Query
    List<User> findUsersSorted();

    // TODO: find surveys by user id
//    @Query
    List<Survey> findSurveysByUserId();
}
