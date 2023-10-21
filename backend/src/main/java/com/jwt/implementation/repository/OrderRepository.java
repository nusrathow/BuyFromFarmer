package com.jwt.implementation.repository;
import com.jwt.implementation.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Query(value = "SELECT max(id) FROM Orders ")
    Long getMaxId();
}
