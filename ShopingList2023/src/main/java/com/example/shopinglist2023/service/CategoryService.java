package com.example.shopinglist2023.service;

import com.example.shopinglist2023.model.entity.Category;
import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
