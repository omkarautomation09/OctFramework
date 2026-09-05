package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;	

}
    By featuredAddToCart = By.xpath("(//span[text()='Add to Cart'])[1]");
    By miniCartButton = By.id("cart");
    By miniCartProductName = By.xpath("//table[@class='table table-striped']//tr/td[2]");
    By miniCartProductPrice = By.xpath("//table[@class='table table-striped']//tr/td[4]");
    By viewCartButton = By.xpath("//a[contains(@href,'checkout/cart')]");
    By featuredAddToWishlist = By.xpath("(//button[@data-original-title='Add to Wish List'])[1]");
    
    
    public void scrollToFeaturedProducts() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,600)");

    }
    
    
    public void clickFeaturedAddToCart() {

        driver.findElement(featuredAddToCart).click();

    }
    
    public void clickMiniCart() {

        driver.findElement(miniCartButton).click();

    }
    
    public String getMiniCartProductName() {

        return driver.findElement(miniCartProductName).getText();

    }
    
    public String getMiniCartProductPrice() {

        return driver.findElement(miniCartProductPrice).getText();

    }
    
    public void clickViewCart() {

        driver.findElement(viewCartButton).click();

    }
    
    public void clickFeaturedAddToWishlist() {

        driver.findElement(featuredAddToWishlist).click();

    }
    
    
    }
