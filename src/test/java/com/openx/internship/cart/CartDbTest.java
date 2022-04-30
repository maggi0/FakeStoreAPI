package com.openx.internship.cart;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CartDbTest {

    Cart cart1 = new Cart(1, Stream.of(
            new Cart.CartProduct(2, 11),
            new Cart.CartProduct(3, 1)
    ).collect(Collectors.toList()));

    Cart cart2 = new Cart(2, Stream.of(
            new Cart.CartProduct(1, 1),
            new Cart.CartProduct(2, 1),
            new Cart.CartProduct(3, 1)
    ).collect(Collectors.toList()));

    Cart cart3 = new Cart(3, Stream.of(
            new Cart.CartProduct(1, 10)
    ).collect(Collectors.toList()));

    @Test
    public void shouldReturnProduct2BasedOnId() throws Exception {
        var cartDb = new CartDb();
        cartDb.cartList = List.of(cart1, cart2, cart3);

        assertEquals(cart2, cartDb.getCart(2));
    }
}
