package com.robert.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // TODO create custom query using JPQL
    @Query(value = "SELECT u FROM User u WHERE u.role = 0")
    List<User> findAllAdminUsers();

    // create custom native query
    @Query(value = "SELECT * FROM user WHERE user.role = 1", nativeQuery = true)
    List<User> findAllOperatorUsers();

    // find sorted users
    @Query(value = "SELECT u FROM User u WHERE u.role = 0 ORDER BY firstName ")
    List<User> findAdminUsersSorted();

}
