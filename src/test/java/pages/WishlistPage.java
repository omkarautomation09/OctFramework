package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
	
	
	WebDriver driver;

    public WishlistPage(WebDriver driver) {

        this.driver = driver;
}
    
    By wishlistLink = By.id("wishlist-total");
    
    public void clickWishlist() {

        driver.findElement(wishlistLink).click();

    }
    
    By wishlistProductName = By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr/td[2]/a");
    
    By wishlistUnitPrice = By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr/td[5]");
    
    By removeProduct = By.xpath("//a[@data-original-title='Remove']");
    
    By successMessage = By.xpath("//div[contains(@class,'alert-success')]");
    
    By addToCartButton = By.xpath("//button[@data-original-title='Add to Cart']");
    
    public String getWishlistProductName() {

        return driver.findElement(wishlistProductName).getText();

    }
    
    public String getWishlistUnitPrice() {

        return driver.findElement(wishlistUnitPrice).getText();

    }
    
    public void clickRemoveProduct() {

        driver.findElement(removeProduct).click();

    }
    
    public String getSuccessMessage() {

        return driver.findElement(successMessage).getText();

    }
    
    public void clickAddToCart() {

        driver.findElement(addToCartButton).click();

    }
    
}
