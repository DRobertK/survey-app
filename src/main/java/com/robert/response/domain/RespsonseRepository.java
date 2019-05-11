package com.robert.response.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespsonseRepository extends JpaRepository<Response, Long> {
}
