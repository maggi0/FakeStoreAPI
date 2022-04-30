package com.openx.internship.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String firstname;
    private String lastname;
    private Address address;
    private String phone;

    public User() {}

    public User(int id, String email, String username, String password, Name name, Address address, String phone) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public User(int id, Address address) {
        this.id = id;
        this.address = address;
    }

    public static class Address {
        private String city;
        private String street;
        private Integer number;
        private String zipcode;
        private Geolocation geolocation;

        public Address () {}

        public Address(String city, String street, Integer number, String zipcode, Geolocation geolocation) {
            this.city = city;
            this.street = street;
            this.number = number;
            this.zipcode = zipcode;
            this.geolocation = geolocation;
        }

        public Address(Geolocation geolocation) {
            this.geolocation = geolocation;
        }

        public static class Geolocation {
            @JsonAlias({"lat"})
            public Double latitude;
            @JsonAlias({"long"})
            public Double longitude;

            public Geolocation() {}

            public Geolocation(Double latitude, Double longitude) {
                this.latitude = latitude;
                this.longitude = longitude;
            }

            public Double getLatitude() {
                return latitude;
            }

            public Double getLongitude() {
                return longitude;
            }
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public Integer getNumber() {
            return number;
        }

        public String getZipcode() {
            return zipcode;
        }

        public Geolocation getGeolocation() {
            return geolocation;
        }
    }

    public static class Name {
        private String firstname;
        private String lastname;

        public Name() {}

        public Name(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
