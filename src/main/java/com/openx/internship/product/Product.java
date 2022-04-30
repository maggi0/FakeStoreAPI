package com.openx.internship.product;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String title;
    private BigDecimal price;
    private String category;
    private String description;
    private String image;
    private Rating rating;

    public Product(int id, String title, BigDecimal price, String category, String description, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }

    public Product(int id, BigDecimal price, String category) {
        this.id = id;
        this.price = price;
        this.category = category;
    }

    public Product() {};

    public static class Rating {
        private double rate;
        private int count;

        public Rating() {}

        public Rating(double rate, int count) {
            this.rate = rate;
            this.count = count;
        }

        public double getRate() {
            return rate;
        }

        public int getCount() {
            return count;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Rating getRating() {
        return rating;
    }
}
