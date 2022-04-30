package com.openx.internship.cart;

import com.openx.internship.product.ProductDb;
import com.openx.internship.user.UserDb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CartService {

    private List<Cart> cartList;
    private CartDb cartDb;
    private ProductDb productDb;
    private UserDb userDb;

    public CartService(CartDb cartDb, ProductDb productDb, UserDb userDb) {
        this.cartDb = cartDb;
        this.productDb = productDb;
        this.userDb = userDb;
        this.cartList = cartDb.getCartList();
    }

    public int findHighestValueCartId() throws IOException {
        var highestValueCartId = -1;
        var highestValue = BigDecimal.valueOf(-1);

        for(Cart cart : cartList) {
            var products = cart.getProducts();
            var value = BigDecimal.valueOf(0);
            for(Cart.CartProduct cartProduct : products) {
                var quantity = cartProduct.getQuantity();
                var price = productDb.getProduct(cartProduct.getProductId()).getPrice();
                value = value.add(price.multiply(BigDecimal.valueOf(quantity)));
            }
            if(value.compareTo(highestValue) > 0) {
                highestValue = value;
                highestValueCartId = cart.getId();
            }
        }
        return highestValueCartId;
    }

    public void printHighestValueCartOwnerAndId() throws IOException {
        var cartId = this.findHighestValueCartId();
        var cart = cartDb.getCart(cartId);
        var firstname = userDb.getUser(cart.getUserId()).getName().getFirstname();
        var lastname = userDb.getUser(cart.getUserId()).getName().getLastname();

        System.out.println("id: " + cartId);
        System.out.println("firstname: " + firstname);
        System.out.println("lastname: " + lastname);
    }
}
