package com.example.shopinglist2023.repository;

import com.example.shopinglist2023.model.entity.Product;
import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;
import com.example.shopinglist2023.model.view.ProductViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT sum (p.price) from Product p")
    BigDecimal findAllProductsSum();

    List<Product> findAllByCategory_Name(CategoryNameEnum categoryNameEnum);


}
