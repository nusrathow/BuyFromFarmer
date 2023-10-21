package com.jwt.implementation.repository;

import com.jwt.implementation.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductListRepository extends JpaRepository<ProductList,Long> {
        @Query(value = "SELECT max(id) FROM ProductList")
        Long getMaxId();

        @Query(value = "SELECT model FROM ProductList model WHERE model.category.id = :categoryId")
        List<ProductList> findProductsByCategoryId(@Param("categoryId") Long categoryId);
}

