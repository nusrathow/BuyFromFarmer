package com.jwt.implementation.repository;

import com.jwt.implementation.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT max(id) FROM Category")
    Long getMaxId();

    /*@Query(value = "SELECT A FROM Category")
    List getAllCategoryName();*/
}
