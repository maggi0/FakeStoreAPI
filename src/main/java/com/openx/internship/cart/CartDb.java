package com.openx.internship.cart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class CartDb {

    List<Cart> cartList;

    public CartDb() throws IOException {
        var cartFakeStoreClient = new CartFakeStoreClient();
        var httpURLConnection = cartFakeStoreClient.fetchCarts();

        var mapper = new ObjectMapper();
        this.cartList = mapper.readValue(httpURLConnection.getInputStream(), new TypeReference<>() {});
    }

    public Cart getCart(int cartId) {
        return cartList.stream()
                .filter(cart -> Integer.valueOf(cartId).equals(Integer.valueOf(cart.getId())))
                .findFirst()
                .get();
    }

    public List<Cart> getCartList() {
        return cartList;
    }
}
