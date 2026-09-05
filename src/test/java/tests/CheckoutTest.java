package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import pages.WishlistPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutNavigationTest() throws InterruptedException {

        SearchPage sp = new SearchPage(getDriver());

        ProductPage pp = new ProductPage(getDriver());

        CartPage cp = new CartPage(getDriver());

        CheckoutPage checkout = new CheckoutPage(getDriver());

        // Search Product
        sp.searchProduct("Mac");

        // Open Product
        pp.clickProduct("MacBook");

        // Add To Cart
        pp.clickAddToCart();

        Thread.sleep(2000);

        // Open Shopping Cart
        cp.clickShoppingCart();

        Thread.sleep(2000);

        // Click Checkout
        checkout.clickCheckout();

        Thread.sleep(2000);

        System.out.println("Current URL = " + getDriver().getCurrentUrl());
        System.out.println("Page Title = " + getDriver().getTitle());
    }
    
    @Test
    public void verifyWishlistToCartOutOfStockTest() throws InterruptedException {

        HomePage hp = new HomePage(getDriver());

        WishlistPage wp = new WishlistPage(getDriver());

        CartPage cp = new CartPage(getDriver());

        LoginPage lp = new LoginPage(getDriver());
        
        CheckoutPage cop = new CheckoutPage(getDriver());

        // Scroll to Featured Products
        hp.scrollToFeaturedProducts();

        Thread.sleep(1000);

        // Add Featured Product to Wishlist
        hp.clickFeaturedAddToWishlist();

        Thread.sleep(2000);

        // Open Wishlist
        wp.clickWishlist();

        Thread.sleep(2000);

        // Login
        lp.login("omkarmg99@grr.la", "Omkar@0921");

        Thread.sleep(2000);

        // If redirected to Home Page, open Wishlist again
        wp.clickWishlist();

        Thread.sleep(2000);

        // Add Wishlist Product to Cart
        wp.clickAddToCart();

        Thread.sleep(2000);

        // Open Cart
        cp.clickShoppingCart();

        Thread.sleep(2000);

        // Capture Out Of Stock message
        String message = cop.getOutOfStockMessage();

        System.out.println("Cart Message = " + message);

        // Verify message
        Assert.assertTrue(
                message.contains("not in stock"),
                "Out Of Stock message not displayed"
        );
    }
    
    
}
