package com.example.shopinglist2023.repository;

import com.example.shopinglist2023.model.entity.Category;
import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{
    Optional<Category> findByName(CategoryNameEnum name);
}
