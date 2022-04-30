package com.openx.internship.user;

import org.junit.Test;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;

public class UserFakeStoreClientTest {

    @Test
    public void shouldGetResponseStatus200() throws Exception {
        var userFakeStoreClient = new UserFakeStoreClient();
        var connection = userFakeStoreClient.fetchUsers();

        var status = connection.getResponseCode();

        assertEquals(HttpURLConnection.HTTP_OK, status);
    }
}
