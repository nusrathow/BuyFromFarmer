package com.jwt.implementation.repository;

import com.jwt.implementation.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FarmerRepository extends JpaRepository<Farmer,Long> {
    @Query(value = "SELECT max(id) FROM Farmer ")
    Long getMaxId();

    @Query(value = "SELECT name FROM Farmer ")
    List findAllFarmer();

}
