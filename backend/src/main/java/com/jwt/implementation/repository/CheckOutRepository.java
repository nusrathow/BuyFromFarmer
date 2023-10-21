package com.jwt.implementation.repository;

import com.jwt.implementation.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CheckOutRepository extends JpaRepository<CheckOut,Long> {
    @Query(value = "SELECT max(id) FROM CheckOut ")
    Long getMaxId();
}
