package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {
	
	@Test
	public void validSearchTest() {
		SearchPage sp = new SearchPage(getDriver());
		sp.searchProduct("MacBook");
		
		Assert.assertTrue(sp.isProductDisplayed("MacBook"),
				                "Product not displayed"
	);
	}
	
	@Test
	public void invalidSearchTest() {
		
		SearchPage sp = new SearchPage(getDriver());
		sp.searchProduct("asdfghjk");
		Assert.assertTrue(getDriver().getPageSource().contains("There is no product that matches the search criteria."),  "No product message not displayed");
	}
 
	@Test
	public void emptySearchTest() {
		
		SearchPage sp = new SearchPage(getDriver());
		sp.searchProduct(" ");
		Assert.assertTrue(
				getDriver().getPageSource().contains("Products meeting the search criteria"),
	            "Products page not displayed"
	    );
		
	}
	
	@Test
	public void partialSearchTest() {

	    SearchPage sp = new SearchPage(getDriver());

	    sp.searchProduct("Mac");

	    Assert.assertTrue(
	            sp.isProductDisplayed("MacBook"),
	            "Partial search failed"
	    );
	}
	
	@Test
	public void caseSensitiveSearchTest() {

	    SearchPage sp = new SearchPage(getDriver());

	    sp.searchProduct("mac");

	    Assert.assertTrue(
	            sp.isProductDisplayed("MacBook"),
	            "Case insensitive search failed"
	    );
	}
	
	@Test
	public void categoryFilterTest() {
		SearchPage sp = new SearchPage(getDriver());

	    
	    sp.searchProduct("Mac");

	    
	    sp.selectCategory("Laptops & Notebooks");

	    
	    sp.clickAdvancedSearchButton();

	    
	    Assert.assertTrue(
	            sp.isProductDisplayed("MacBook"),
	            "Category filter failed"
	    );
	}
	
	@Test
	public void subCategoryFilterTest() {
		SearchPage sp = new SearchPage(getDriver());
        
		sp.searchProduct("Mac");

	    
	    sp.selectCategory("Laptops & Notebooks");
	    
	    sp.clickSubCategory();

	    
	    sp.clickAdvancedSearchButton();

	    
	    Assert.assertTrue(
	            sp.isProductDisplayed("MacBook"),
	            "Subcategory filter failed"
	    );
		
	}
	
	@Test 
	public void descriptionFilterTest() {
		SearchPage sp= new SearchPage(getDriver());
		sp.searchProduct("Mac");

	    sp.selectCategory("Laptops & Notebooks");

	    sp.clickDescriptionCheckBox();

	    sp.clickAdvancedSearchButton();

	    Assert.assertTrue(
	            sp.isProductDisplayed("MacBook"),
	            "Description filter failed"
	    );
	
		
	}
	
	@Test
	public void combinedFilterTest() {

	    SearchPage sp = new SearchPage(getDriver());

	    sp.searchProduct("Mac");

	    sp.selectCategory("Laptops & Notebooks");

	    sp.clickSubCategory();

	    sp.clickDescriptionCheckBox();

	    sp.clickAdvancedSearchButton();

	    Assert.assertTrue(
	            sp.isProductDisplayed("MacBook"),
	            "Combined Filter Test Failed"
	    );
	}
	
	@Test
	public void wrongCategoryFilterTest() {

	    SearchPage sp = new SearchPage(getDriver());

	    sp.searchProduct("Mac");

	    sp.selectCategory("Cameras");

	    sp.clickAdvancedSearchButton();

	    Assert.assertTrue(
	    		getDriver().getPageSource().contains("There is no product that matches the search criteria."),
	            "Wrong Category Test Failed"
	    );
	}
	
	@Test
	public void invalidSearchWithCategoryTest() {

	    SearchPage sp = new SearchPage(getDriver());

	    sp.searchProduct("ABCDEFG");

	    sp.selectCategory("Laptops & Notebooks");

	    sp.clickAdvancedSearchButton();

	    Assert.assertTrue(
	    		getDriver().getPageSource().contains("There is no product that matches the search criteria."),
	            "Invalid Search With Category Failed"
	    );
	}
	
	
	
}
