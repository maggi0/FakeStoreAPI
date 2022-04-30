package com.openx.internship.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ProductDb {

    List<Product> productList;

    public ProductDb() throws IOException {
        var productFakeStoreClient = new ProductFakeStoreClient();
        var httpURLConnection = productFakeStoreClient.fetchProducts();

        var mapper = new ObjectMapper();
        this.productList = mapper.readValue(httpURLConnection.getInputStream(), new TypeReference<>() {});
    }

    public Product getProduct(int productId) {
        return productList.stream()
                .filter(product -> Integer.valueOf(productId).equals(Integer.valueOf(product.getId())))
                .findFirst()
                .get();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
