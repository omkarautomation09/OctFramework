package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Checkout button from Cart page
    By checkoutButton = By.xpath("//a[contains(@href,'checkout/checkout')]");
    
    By outOfStockMessage = By.xpath("//div[contains(@class,'alert-danger')]");

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
    
    public String getOutOfStockMessage() {

        return driver.findElement(outOfStockMessage).getText();

    }

}