package com.openx.internship.cart;

import com.openx.internship.product.Product;
import com.openx.internship.product.ProductDb;
import com.openx.internship.user.UserDb;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CartServiceTest {

//  productId 1 price = 109.95
//  productId 2 price = 22.3
//  productId 3 price = 55.99

    Cart cart1 = new Cart(1,Stream.of(
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
    public void returnsCart3BasedOnCartValues() throws Exception {
        var cartDb = new CartDb();
        cartDb.cartList = List.of(cart1, cart2, cart3);
        var userDb = new UserDb();
        var productDb = new ProductDb();

        var cartService = new CartService(cartDb, productDb, userDb);

        assertEquals(3, cartService.findHighestValueCartId());
    }
}
