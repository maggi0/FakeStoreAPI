package com.openx.internship.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class UserDb {
    List<User> userList;

    public UserDb() throws IOException {
        var userFakeStoreClient = new UserFakeStoreClient();
        var httpURLConnection = userFakeStoreClient.fetchUsers();

        var mapper = new ObjectMapper();
        this.userList = mapper.readValue(httpURLConnection.getInputStream(), new TypeReference<>() {});
    }

    public User getUser(int userId) {
        return userList.stream()
                .filter(user -> Integer.valueOf(userId).equals(Integer.valueOf(user.getId())))
                .findFirst()
                .get();
    }

    public User getUser(double latitude, double longitude) {
        return userList.stream()
                .filter(user -> Double.valueOf(latitude).equals(Double.valueOf(user.getAddress().getGeolocation().getLatitude()))
                && Double.valueOf(longitude).equals(Double.valueOf(user.getAddress().getGeolocation().getLongitude())))
                .findFirst()
                .get();
    }
}
