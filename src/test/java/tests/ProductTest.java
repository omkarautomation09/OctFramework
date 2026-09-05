package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductPage;
import pages.SearchPage;
import retry.RetryAnalyzer;


public class ProductTest extends BaseTest {

	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	
	public void openProductTest() {
		
		SearchPage sp = new SearchPage(getDriver());
		ProductPage pp = new ProductPage(getDriver());
		
		sp.searchProduct("Mac");
		pp.clickProduct("MacBook");
		
		Assert.assertTrue(

				getDriver().getTitle().contains("MacBook"),

                "Product Page Not Opened"

        );

    }
	
	@Test
	public void verifyProductNameTest() {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");
	    pp.clickProduct("MacBook");

	    Assert.assertEquals(
	            pp.getProductName(),
	            "MacBook",
	            "Product Name Mismatch"
	    );
	}
		
	@Test
	public void verifyProductPriceTest() {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    Assert.assertEquals(
	            pp.getProductPrice(),
	            "$602.00",
	            "Product Price Mismatch"
	    );

	}
	
	@Test
	public void verifyAvailabilityTest() {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    Assert.assertEquals(
	            pp.getAvailability(),
	            "Availability: In Stock",
	            "Availability Mismatch"
	    );

	}
	
	@Test
	public void verifyProductImageTest() {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    Assert.assertTrue(
	            pp.isProductImageDisplayed(),
	            "Product Image is not displayed"
	    );

	}
	
	@Test
	public void verifyQuantityTest() {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");
	    
	    System.out.println("the product quantity is "+ pp.getQuantity());

	    Assert.assertEquals(
	            pp.getQuantity(),
	            "1",
	            "Default Quantity Mismatch"
	    );

	}
	
	@Test
	public void verifyAddToCartButtonTest() {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    Assert.assertTrue(
	            pp.isAddToCartButtonDisplayed(),
	            "Add To Cart Button is not displayed"
	    );

	}
	
	@Test
	public void addProductToCartTest() throws InterruptedException {

	    SearchPage sp = new SearchPage(getDriver());
	    ProductPage pp = new ProductPage(getDriver());

	    sp.searchProduct("Mac");

	    pp.clickProduct("MacBook");

	    pp.clickAddToCart();
	    
	    Thread.sleep(2000);

	    System.out.println(pp.getSuccessMessage());

	    Assert.assertTrue(
	            pp.getSuccessMessage().contains("Success"),
	            "Product was not added to cart"
	    );

	}
	
	@Test
	public void openFeaturedProductTest() {

	    ProductPage pp = new ProductPage(getDriver());

	    pp.clickFeaturedProduct("MacBook");

	    Assert.assertTrue(
	    		getDriver().getTitle().contains("MacBook"),
	            "Featured Product Page Not Opened"
	    );
	}
}
