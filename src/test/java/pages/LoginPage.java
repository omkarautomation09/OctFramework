package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

	WebDriver driver;
	
		public LoginPage(WebDriver driver) {
			this.driver=driver;
		}
		
		By Account = By.xpath("//a[@title='My Account']");
		By loginOption = By.linkText("Login");
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		// 🔹 Action 1 → navigate to login page
	    public void goToLoginPage() {
	        WaitUtils wu = new WaitUtils(driver);

	        wu.waitForElementClickable(Account);
	        driver.findElement(Account).click();

	        wu.waitForElementClickable(loginOption);
	        driver.findElement(loginOption).click();
	    }

	    // 🔹 Action 2 → perform login
	    public void login(String user, String pass) {
	        driver.findElement(email).sendKeys(user);//omkarmg99@grr.la
	        driver.findElement(password).sendKeys(pass);//Omkar@0921
	        driver.findElement(loginBtn).click();
	    }

}
