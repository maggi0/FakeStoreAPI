package com.openx.internship;

import com.openx.internship.cart.CartDb;
import com.openx.internship.cart.CartService;
import com.openx.internship.product.ProductDb;
import com.openx.internship.product.ProductService;
import com.openx.internship.user.UserDb;
import com.openx.internship.user.UserService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var productDb = new ProductDb();
        var userDb = new UserDb();
        var cartDb = new CartDb();

        var productService = new ProductService(productDb);
        var userService = new UserService(userDb);
        var cartService = new CartService(cartDb, productDb, userDb);

        System.out.println("All available product categories and their total value: ");
        productService.printCategoriesMap(productService);

        System.out.println();
        System.out.println("Owner and id of the cart with the highest value: ");
        cartService.printHighestValueCartOwnerAndId();

        System.out.println();
        System.out.println("Names of the two users living furthest away from each other");
        userService.printTwoUsersLivingFurthestApart();

    }
}
