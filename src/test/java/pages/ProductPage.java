package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	WebDriver driver;
	public  ProductPage(WebDriver driver ){
		this.driver = driver;		
	}
	
	By macBookLink = By.linkText("MacBook");
	
	By productName = By.xpath("//div[@id='content']//h1");
	
	By productPrice = By.xpath("//ul[@class='list-unstyled'][2]/li/h2");////ul[@class='list-unstyled'][2]/li/h2
	
	By availability = By.xpath("//li[contains(text(),'Availability')]");
	
	By productImage = By.xpath("//img[@title='MacBook']");
	
	By quantity = By.id("input-quantity");
	
	By addToCartBtn = By.id("button-cart");
	
	By successMessage = By.xpath("//div[contains(@class,'alert-success')]");
	
	By addToWishlist = By.xpath("//button[@data-original-title='Add to Wish List']");
	
	
	public void clickProduct(String productName) {
		
	    driver.findElement(By.linkText(productName)).click();

	}
	
	public String getProductName() {
		
		return driver.findElement(productName).getText();
	}
	
	public String getProductPrice() {
		return driver.findElement(productPrice).getText() ;
	}
	
	public String getAvailability() {

	    return driver.findElement(availability).getText();

	}
	
	public boolean isProductImageDisplayed() {

	    return driver.findElement(productImage).isDisplayed();

	}
	
	public String getQuantity() {
		
		return driver.findElement(quantity).getAttribute("value");
		}
	
	public boolean isAddToCartButtonDisplayed() {

	    return driver.findElement(addToCartBtn).isDisplayed();

	}
	
	public String getSuccessMessage() {

	    return driver.findElement(successMessage).getText();

	}
	
	public void clickAddToCart() {

	    driver.findElement(addToCartBtn).click();

	}
	
	public void clickFeaturedProduct(String productName) {

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("window.scrollBy(0,700)");
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    driver.findElement(By.linkText(productName)).click();

	}
	
	public void enterQuantity(String qty) {

	    WebElement quantityBox = driver.findElement(quantity);

	    quantityBox.clear();

	    quantityBox.sendKeys(qty);

	}
	
	public void clickAddToWishlist() {

	    driver.findElement(addToWishlist).click();

	}
}
