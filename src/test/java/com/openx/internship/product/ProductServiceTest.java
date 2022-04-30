package com.openx.internship.product;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {

    Product product1 = new Product(1, BigDecimal.valueOf(2), "cat1");
    Product product2 = new Product(2, BigDecimal.valueOf(10), "cat2");
    Product product3 = new Product(3, BigDecimal.valueOf(5), "cat1");

    @Test
    public void shouldSumPricesOfProduct1AndProduct3BasedOnCategory() throws Exception {
        var productDb = new ProductDb();
        productDb.productList = List.of(product1, product2, product3);
        var productService = new ProductService(productDb);
        var serviceCategoriesValuesMap = productService.getTotalValueOfCategories();

        var categoriesValuesMap = new HashMap<String, BigDecimal>();
        categoriesValuesMap.put("cat1", BigDecimal.valueOf(7));
        categoriesValuesMap.put("cat2", BigDecimal.valueOf(10));

        assertEquals(categoriesValuesMap, serviceCategoriesValuesMap);
    }
}
