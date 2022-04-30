package com.openx.internship.user;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class UserDbTest {

    User user1 = new User(1, new User.Address(new User.Address.Geolocation(21.32, 21.35)));
    User user2 = new User(2, new User.Address(new User.Address.Geolocation(21.32, 21.37)));
    User user3 = new User(3, new User.Address(new User.Address.Geolocation(32.85, 21.37)));

    @Test
    public void shouldReturnUser2BasedOnId() throws Exception {
        UserDb userDb = new UserDb();
        userDb.userList = List.of(user1, user2, user3);

        assertEquals(user2, userDb.getUser(2));
    }

    @Test
    public void shouldReturnUser3BasedOnGeolocation() throws Exception {
        UserDb userDb = new UserDb();
        userDb.userList = List.of(user1, user2, user3);

        assertEquals(user3, userDb.getUser(32.85, 21.37));
    }


}
