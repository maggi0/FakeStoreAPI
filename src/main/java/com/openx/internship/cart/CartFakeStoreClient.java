package com.openx.internship.cart;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CartFakeStoreClient {
    public HttpURLConnection fetchCarts() throws IOException {
        final var url = new URL("https://fakestoreapi.com/carts");
        var connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        return connection;
    }
}
