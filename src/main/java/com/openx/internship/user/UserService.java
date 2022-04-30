package com.openx.internship.user;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private List<User> userList;
    private UserDb userDb;

    public UserService(UserDb userDb) {
        this.userDb = userDb;
        this.userList = userDb.userList;
    }

    public List<User> findTwoUsersFurthestApart() throws IOException {

        var geolocationList = userList.stream().
                map(User::getAddress).map(v -> v.getGeolocation())
                .collect(Collectors.toList());

        var highestDistance = 0.0;
        var firstHighestDistanceLatitude = 0.0;
        var secondHighestDistanceLatitude = 0.0;
        var firstHighestDistanceLongitude = 0.0;
        var secondHighestDistanceLongitude = 0.0;

        for (int i = 0; i < geolocationList.size(); i++) {
            for (int j = i+1; j < geolocationList.size(); j++) {
                var y1 = geolocationList.get(i).getLatitude();
                var y2 = geolocationList.get(j).getLatitude();
                var x1 = geolocationList.get(i).getLongitude();
                var x2 = geolocationList.get(j).getLongitude();
                var distance = Point2D.distance(x1, y1, x2, y2);
                if(distance > highestDistance) {
                    highestDistance = distance;
                    firstHighestDistanceLatitude = y1;
                    firstHighestDistanceLongitude = x1;
                    secondHighestDistanceLatitude = y2;
                    secondHighestDistanceLongitude = x2;
                }
            }
        }

        var firstUser = userDb.getUser(firstHighestDistanceLatitude, firstHighestDistanceLongitude);
        var secondUser = userDb.getUser(secondHighestDistanceLatitude, secondHighestDistanceLongitude);

        return List.of(firstUser, secondUser);
    }

    public void printTwoUsersLivingFurthestApart() throws IOException {
        var twoUsersList = this.findTwoUsersFurthestApart();
        System.out.println("Name of the first user: ");
        System.out.println("firstname: " + twoUsersList.get(0).getName().getFirstname());
        System.out.println("lastname: " + twoUsersList.get(0).getName().getLastname());

        System.out.println("Name of the second user: ");
        System.out.println("firstname: " + twoUsersList.get(1).getName().getFirstname());
        System.out.println("lastname: " + twoUsersList.get(1).getName().getLastname());
    }
}
