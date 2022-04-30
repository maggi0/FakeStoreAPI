package com.openx.internship.product;

import com.openx.internship.user.UserDb;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDbTest {

    Product product1 = new Product(1, BigDecimal.valueOf(2), "cat1");
    Product product2 = new Product(2, BigDecimal.valueOf(5), "cat1");
    Product product3 = new Product(3, BigDecimal.valueOf(10), "cat2");

    @Test
    public void shouldReturnProduct2BasedOnId() throws Exception {
        var productDb = new ProductDb();
        productDb.productList = List.of(product1, product2, product3);

        assertEquals(product2, productDb.getProduct(2));
    }
}
