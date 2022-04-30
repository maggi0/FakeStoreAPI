package com.openx.internship.user;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserFakeStoreClient {
    public HttpURLConnection fetchUsers() throws IOException {
        final var url = new URL("https://fakestoreapi.com/users");
        var connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        return connection;
    }
}
