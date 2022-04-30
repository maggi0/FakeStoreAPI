package com.openx.internship.cart;

import org.junit.Test;

import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;
public class CartFakeStoreClientTest {

    @Test
    public void shouldGetResponseStatus200() throws Exception {
        var cartFakeStoreClient = new CartFakeStoreClient();
        var connection = cartFakeStoreClient.fetchCarts();

        var status = connection.getResponseCode();

        assertEquals(HttpURLConnection.HTTP_OK, status);
    }
}
