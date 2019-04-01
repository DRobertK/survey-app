package com.robert.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMonkeyRepository extends JpaRepository<UserMonkey, Long> {


}
