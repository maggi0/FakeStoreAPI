package com.openx.internship.product;

import org.junit.Test;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;

public class ProductFakeStoreClientTest {

    @Test
    public void shouldGetResponseStatus200() throws Exception {
        var productFakeStoreClient = new ProductFakeStoreClient();
        var connection = productFakeStoreClient.fetchProducts();

        var status = connection.getResponseCode();

        assertEquals(HttpURLConnection.HTTP_OK, status);
    }
}
