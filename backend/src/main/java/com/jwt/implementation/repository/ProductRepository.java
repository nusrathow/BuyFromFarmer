package com.jwt.implementation.repository;
import com.jwt.implementation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT max(id) FROM Product ")
    Long getMaxId();

    @Query(value = "SELECT model FROM Product model WHERE model.prodListId.id = :prodListId")
    List<Product> findAllProductById(@Param("prodListId") Long prodListId);


}
