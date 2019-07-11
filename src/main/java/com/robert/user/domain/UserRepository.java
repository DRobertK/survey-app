package com.robert.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Profile, Long> {

    //     TODO create custom query using JPQL
    @Query(value = "SELECT * FROM account WHERE account.role = 0", nativeQuery = true)
    List<Profile> findAllAdminUsers();

    // create custom native query
    @Query(value = "SELECT * FROM account WHERE account.role = 1", nativeQuery = true)
    List<Profile> findAllOperatorUsers();

    //    // find sorted users
    @Query(value = "SELECT * FROM account WHERE account.role = 0 ORDER BY userName", nativeQuery = true)
    List<Profile> findAdminUsersSorted();

}
