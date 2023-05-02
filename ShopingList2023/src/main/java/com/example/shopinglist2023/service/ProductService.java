package com.example.shopinglist2023.service;

import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;
import com.example.shopinglist2023.model.service.ProductAddServiceModel;
import com.example.shopinglist2023.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addItem(ProductAddServiceModel productAddServiceModel);

    BigDecimal findAllItemsPrice();

    List<ProductViewModel> findAllProdByCatgName(CategoryNameEnum categoryNameEnum);

    void buy(Long id);

    void buyAllProducts();
}
