package com.example.shopinglist2023.init;

import com.example.shopinglist2023.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

        private final CategoryService categoryService;

        public DataBaseInit(CategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @Override
        public void run(String... args) throws Exception {
            categoryService.initCategories();
        }
}
