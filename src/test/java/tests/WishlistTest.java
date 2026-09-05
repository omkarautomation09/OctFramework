package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistTest extends BaseTest {

	@Test
	public void verifyAddToWishlistTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());

	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    pp.clickAddToWishlist();

	    Thread.sleep(2000);

	}
	
	@Test
	public void verifyWishlistNavigationTest() throws InterruptedException {
		
		SearchPage sp = new SearchPage(getDriver());

	    ProductPage pp = new ProductPage(getDriver());

	    WishlistPage wp = new WishlistPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    pp.clickAddToWishlist();

	    Thread.sleep(2000);

	    wp.clickWishlist();

	    Thread.sleep(2000);
	}
	
	@Test
	public void verifyWishlistCompleteFlowTest() throws InterruptedException {
		
		LoginPage lp = new LoginPage(getDriver());

		SearchPage sp = new SearchPage(getDriver());

		ProductPage pp = new ProductPage(getDriver());

		WishlistPage wp = new WishlistPage(getDriver());
		
		// Search Product
		sp.searchProduct("Mac");

		// Open Product
		pp.clickProduct("MacBook");

		// Add To Wishlist
		pp.clickAddToWishlist();

		Thread.sleep(2000);

		// Open Wishlist
		wp.clickWishlist();

		Thread.sleep(2000);

		// Login
		lp.login("omkarmg99@grr.la", "Omkar@0921");

		Thread.sleep(2000);
		
	}
	
	@Test 
	
	public void verifyWishlistEndToEndTest() throws InterruptedException {
		
		LoginPage lp = new LoginPage(getDriver());
	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());
	    WishlistPage wp = new WishlistPage(getDriver());

	    // Search Product
	    sp.searchProduct("Mac");

	    // Open Product
	    pp.clickProduct("MacBook");

	    // Add To Wishlist
	    pp.clickAddToWishlist();

	    Thread.sleep(2000);

	    // Open Wishlist
	    wp.clickWishlist();

	    Thread.sleep(2000);

	    // Login
	    lp.login("omkarmg99@grr.la", "Omkar@0921");

	    Thread.sleep(2000);

	    // Check where we are after login
	    System.out.println(getDriver().getCurrentUrl());
	    System.out.println(getDriver().getTitle());

	    // If login redirects to Home Page,
	    // click Wishlist again.
	    wp.clickWishlist();

	    Thread.sleep(2000);

	    // Capture Product Details
	    String productName = wp.getWishlistProductName();
	    String unitPrice = wp.getWishlistUnitPrice();

	    System.out.println("Wishlist Product = " + productName);
	    System.out.println("Wishlist Price = " + unitPrice);

	    // Verify Product Details
	    Assert.assertEquals(
	            productName,
	            "MacBook",
	            "Product Name Mismatch"
	    );

	    Assert.assertEquals(
	            unitPrice,
	            "$602.00",
	            "Price Mismatch"
	    );

	    // Remove Product
	    wp.clickRemoveProduct();

	    Thread.sleep(2000);

	    // Verify Success Message
	    String success = wp.getSuccessMessage();

	    System.out.println(success);

	    Assert.assertTrue(
	            success.contains("Success"),
	            "Wishlist Remove Failed"
	    );
	}
}
