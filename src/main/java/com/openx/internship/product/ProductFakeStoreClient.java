package com.openx.internship.product;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductFakeStoreClient {
    public HttpURLConnection fetchProducts() throws IOException {
        final var url = new URL("https://fakestoreapi.com/products");
        var connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        return connection;
    }
}
