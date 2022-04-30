package com.openx.internship.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {
    private int id;
    private int userId;
    private String date;
    private List<CartProduct> products;
    private int productId;
    private int quantity;

    public Cart() {}

    public Cart(int id, int userId, String date, List<CartProduct> products) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

    public Cart(int id, List<CartProduct> products) {
        this.id = id;
        this.products = products;
    }

    public static class CartProduct {
        private int productId;
        private int quantity;

        public CartProduct(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public CartProduct () {}

        public int getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public List<CartProduct> getProducts() {
        return products;
    }
}
