package com.openx.internship.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class ProductService {

    private List<Product> productList;

    public ProductService(ProductDb productDb) {
        this.productList = productDb.getProductList();
    }

    public HashMap<String, BigDecimal> getTotalValueOfCategories() throws IOException {

        var productCategoriesValue = new ProductCategoriesValue();

        var categoriesMap = productList.stream()
                .collect(Collectors.toMap(Product::getCategory, Product::getPrice, BigDecimal::add));
        categoriesMap.entrySet().stream().forEach(e -> productCategoriesValue.addCategory(e.getKey(), e.getValue()));

        return (HashMap<String, BigDecimal>) productCategoriesValue.getTotalValueOfCategories();
    }

    public void printCategoriesMap(ProductService productService) throws IOException {
        var valueOfCategoriesMap = productService.getTotalValueOfCategories();

        valueOfCategoriesMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
