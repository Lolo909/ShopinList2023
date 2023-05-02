package com.example.shopinglist2023.service;

import com.example.shopinglist2023.model.entity.Product;
import com.example.shopinglist2023.model.entity.enums.CategoryNameEnum;
import com.example.shopinglist2023.model.service.ProductAddServiceModel;
import com.example.shopinglist2023.model.service.UserServiceModel;
import com.example.shopinglist2023.model.view.ProductViewModel;
import com.example.shopinglist2023.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ProductAddServiceModel productAddServiceModel) {

        Product product = modelMapper.map(productAddServiceModel, Product.class);
        //product.setClient(userService.findById(currentUser.getId()));
        product.setCategory(categoryService.findByCategoryNameEnum(productAddServiceModel.getCategory()));
        //product.setGender(productAddServiceModel.getGender());

        productRepository.save(product);
    }


public BigDecimal sum;
    @Override
    public BigDecimal findAllItemsPrice() {
        return productRepository.findAllProductsSum();

    }

    @Override
    public List<ProductViewModel> findAllProdByCatgName(CategoryNameEnum categoryNameEnum) {
        return productRepository.findAllByCategory_Name(categoryNameEnum)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
