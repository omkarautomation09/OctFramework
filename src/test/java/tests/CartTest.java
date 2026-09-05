package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class CartTest extends BaseTest {

	@Test
	 public void verifyCartProductTest() throws InterruptedException {
		
		 SearchPage sp = new SearchPage(getDriver());

	     ProductPage pp = new ProductPage(getDriver());
	        
	     CartPage cp = new CartPage(getDriver());
	     
	  // Search Product  
	     sp.searchProduct("Mac");

	        // Open Product
	     pp.clickProduct("MacBook");

	        // Add To Cart
	     pp.clickAddToCart();

	  // Temporary Wait
	        Thread.sleep(2000);

	        // Open Shopping Cart
	        cp.clickShoppingCart();

	        // Verify Product Name
	        Assert.assertEquals(
	                cp.getCartProductName(),
	                "MacBook",
	                "Product not found in Shopping Cart"
	        );
	     
	}
	
	@Test
	public void verifyCartQuantityTest() throws InterruptedException {
		
		SearchPage sp = new SearchPage(getDriver());

	     ProductPage pp = new ProductPage(getDriver());
	        
	     CartPage cp = new CartPage(getDriver());
	     
	  // Search Product  
	     sp.searchProduct("Mac");

	        // Open Product
	     pp.clickProduct("MacBook");

	        // Add To Cart
	     pp.clickAddToCart();

	  // Temporary Wait
	        Thread.sleep(2000);

	        // Open Shopping Cart
	        cp.clickShoppingCart();
	        
	        Assert.assertEquals(
	                cp.getCartQuantity(),
	                "1",
	                "Cart Quantity Mismatch"
	        );
		
	}
	
	@Test
	public void verifyUnitPriceTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());
	    CartPage cp = new CartPage(getDriver());

	    sp.searchProduct("Mac");
	    pp.clickProduct("MacBook");
	    pp.clickAddToCart();

	    Thread.sleep(2000);

	    cp.clickShoppingCart();
	    
	    System.out.println("Unit Price = " + cp.getUnitPrice());

	    Assert.assertEquals(
	            cp.getUnitPrice(),
	            "$602.00",
	            "Unit Price Mismatch"
	    );
	}

	@Test
	public void verifyTotalPriceTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());
	    CartPage cp = new CartPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    pp.clickAddToCart();

	    Thread.sleep(2000);

	    cp.clickShoppingCart();

	    System.out.println("Total Price = " + cp.getTotalPrice());

	    Assert.assertEquals(
	            cp.getTotalPrice(),
	            "$602.00",
	            "Total Price Mismatch"
	    );
	}
	
	@Test
	public void verifyCartQuantityAfterUpdateTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());

	    ProductPage pp = new ProductPage(getDriver());

	    CartPage cp = new CartPage(getDriver());

	    // Search Product
	    sp.searchProduct("Mac");

	    // Open Product
	    pp.clickProduct("MacBook");

	    // Change Quantity on Product Page
	    pp.enterQuantity("2");

	    // Add To Cart
	    pp.clickAddToCart();

	    // Temporary Wait
	    Thread.sleep(2000);

	    // Open Shopping Cart
	    cp.clickShoppingCart();

	    System.out.println("Cart Quantity = " + cp.getCartQuantity());

	    Assert.assertEquals(
	            cp.getCartQuantity(),
	            "2",
	            "Cart Quantity Mismatch"
	    );
	}
	
	@Test
	public void verifyCartAfterChangingQuantityTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());

	    ProductPage pp = new ProductPage(getDriver());

	    CartPage cp = new CartPage(getDriver());

	    // Search Product
	    sp.searchProduct("Mac");

	    // Open Product
	    pp.clickProduct("MacBook");

	    // Change Quantity to 2
	    pp.enterQuantity("2");

	    // Add To Cart
	    pp.clickAddToCart();

	    // Wait
	    Thread.sleep(2000);

	    // Open Shopping Cart
	    cp.clickShoppingCart();

	    // Print Values
	    System.out.println("Quantity = " + cp.getCartQuantity());
	    System.out.println("Unit Price = " + cp.getUnitPrice());
	    System.out.println("Total Price = " + cp.getTotalPrice());

	    // Verify Quantity
	    Assert.assertEquals(
	            cp.getCartQuantity(),
	            "2",
	            "Quantity Mismatch"
	    );

	    // Verify Unit Price
	    Assert.assertEquals(
	            cp.getUnitPrice(),
	            "$602.00",
	            "Unit Price Mismatch"
	    );

	    // Verify Total Price
	    Assert.assertEquals(
	            cp.getTotalPrice(),
	            "$1204.00",
	            "Total Price Mismatch"
	    );
	}
	
	@Test
	public void updateCartQuantityTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());

	    ProductPage pp = new ProductPage(getDriver());

	    CartPage cp = new CartPage(getDriver());

	    // Search Product
	    sp.searchProduct("Mac");

	    // Open Product
	    pp.clickProduct("MacBook");

	    // Add To Cart
	    pp.clickAddToCart();

	    Thread.sleep(2000);

	    // Open Shopping Cart
	    cp.clickShoppingCart();

	    // Change Quantity
	    cp.updateCartQuantity("5");
	    
	    Thread.sleep(2000);

	    // Click Update
	    cp.clickUpdateButton();

	    Thread.sleep(2000);

	    // Print Values
	    System.out.println("Quantity = " + cp.getCartQuantity());
	    System.out.println("Total Price = " + cp.getTotalPrice());

	    // Verify Quantity
	    Assert.assertEquals(
	            cp.getCartQuantity(),
	            "5",
	            "Quantity Update Failed"
	    );

	    // Verify Total Price
	    Assert.assertEquals(
	            cp.getTotalPrice(),
	            "$3,010.00",
	            "Total Price Update Failed"
	    );

	}
	

	@Test
	public void removeProductTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());

	    ProductPage pp = new ProductPage(getDriver());

	    CartPage cp = new CartPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    pp.clickAddToCart();

	    Thread.sleep(2000);

	    cp.clickShoppingCart();

	    cp.clickRemoveProduct();

	    Thread.sleep(2000);

	    System.out.println(cp.getEmptyCartMessage());

	    Assert.assertEquals(
	            cp.getEmptyCartMessage(),
	            "Your shopping cart is empty!",
	            "Product Not Removed"
	    );

	}

	@Test
	public void verifyFeaturedProductMiniCartTest1() throws InterruptedException {

	    HomePage hp = new HomePage(getDriver());

	    hp.scrollToFeaturedProducts();

	    Thread.sleep(2000);

	    hp.clickFeaturedAddToCart();

	    Thread.sleep(2000);

	}
	
	@Test
	public void verifyFeaturedAddToCartTest() throws InterruptedException {

	    HomePage hp = new HomePage(getDriver());

	    hp.scrollToFeaturedProducts();

	    Thread.sleep(2000);

	    hp.clickFeaturedAddToCart();

	    Thread.sleep(2000);

	}
	
	@Test
	public void verifyFeaturedProductMiniCartTest() throws InterruptedException {
		HomePage hp = new HomePage(getDriver());

		hp.scrollToFeaturedProducts();

		Thread.sleep(2000);

		hp.clickFeaturedAddToCart();

		Thread.sleep(2000);

		hp.clickMiniCart();

		Thread.sleep(2000);
	}
	
	@Test
	public void verifyMiniCartDetailsTest() throws InterruptedException {
		
		HomePage hp = new HomePage(getDriver());

		hp.scrollToFeaturedProducts();

		Thread.sleep(2000);

		hp.clickFeaturedAddToCart();

		Thread.sleep(2000);

		hp.clickMiniCart();

		Thread.sleep(2000);
		
		String miniName = hp.getMiniCartProductName();

		String miniPrice = hp.getMiniCartProductPrice();

		System.out.println("Mini Cart Product = " + miniName);

		System.out.println("Mini Cart Price = " + miniPrice);
	}
	
	@Test
	public void verifyMiniCartAndShoppingCartDataTest() throws InterruptedException{
	
	HomePage hp = new HomePage(getDriver());
	CartPage cp = new CartPage(getDriver());

	hp.scrollToFeaturedProducts();

	Thread.sleep(2000);

	hp.clickFeaturedAddToCart();

	Thread.sleep(2000);

	hp.clickMiniCart();

	Thread.sleep(2000);
	
	String miniName = hp.getMiniCartProductName();

	String miniPrice = hp.getMiniCartProductPrice();

	System.out.println("Mini Cart Product = " + miniName);

	System.out.println("Mini Cart Price = " + miniPrice);
	
	hp.clickViewCart();

	Thread.sleep(2000);

	String cartName = cp.getCartProductName();

	String cartPrice = cp.getUnitPrice();

	System.out.println("Cart Product = " + cartName);

	System.out.println("Cart Price = " + cartPrice);
	
	Assert.assertEquals(
	        miniName,
	        cartName,
	        "Product Name Mismatch"
	);

	Assert.assertEquals(
	        miniPrice,
	        cartPrice,
	        "Price Mismatch"
	);
	

}}
