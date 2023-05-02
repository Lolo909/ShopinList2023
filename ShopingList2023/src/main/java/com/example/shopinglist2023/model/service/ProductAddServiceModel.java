package com.example.shopinglist2023.model.service;

import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddServiceModel {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime neededBefore;

    private CategoryNameEnum category;

    public ProductAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddServiceModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductAddServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
