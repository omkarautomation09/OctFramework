package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

WebDriver driver;
	
	public CartPage (WebDriver driver) {
		
		this.driver=driver;
		
	}	
	
	By shoppingCartLink = By.linkText("shopping cart");
	
	By cartProductName = By.linkText("MacBook");
	
	By cartQuantity = By.xpath("//input[contains(@name,'quantity')]");
	
	By cartUnitPrice = By.xpath("//table[@class='table table-bordered']//tbody/tr/td[5]");
	
	By cartTotalPrice = By.xpath("//tbody/tr/td[6]");
	
	By updateButton = By.xpath("//button[@data-original-title='Update']");
	
	By removeButton = By.xpath("//button[@data-original-title='Remove']");
	
	By emptyCartMessage = By.xpath("//div[@id='content']/p");
	
	public void clickShoppingCart() {
		
		driver.findElement(shoppingCartLink).click();
	}
	

	public String getCartProductName() {

        return driver.findElement(cartProductName).getText();

    }
	
	public String getCartQuantity() {

	    return driver.findElement(cartQuantity).getAttribute("value");

	}
	
	public String getUnitPrice() {

	    return driver.findElement(cartUnitPrice).getText();

	}
	
	public String getTotalPrice() {

	    return driver.findElement(cartTotalPrice).getText();

	}
	
	public void updateCartQuantity(String qty) {

	    driver.findElement(cartQuantity).clear();

	    driver.findElement(cartQuantity).sendKeys(qty);

	}
	
	public void clickUpdateButton() {

	    driver.findElement(updateButton).click();

	}
	
	public void clickRemoveProduct() {

	    driver.findElement(removeButton).click();

	}
	
	public String getEmptyCartMessage() {

	    return driver.findElement(emptyCartMessage).getText();

	}
	
}
