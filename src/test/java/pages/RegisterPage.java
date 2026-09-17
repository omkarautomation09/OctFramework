package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By Account = By.xpath("//a[@title='My Account']");
    By registerOption = By.linkText("Register");

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");

    By newsletterYes = By.cssSelector("input[name='newsletter'][value='1']");
    By newsletterNo = By.cssSelector("input[name='newsletter'][value='0']");

    By privacyPolicy = By.cssSelector("input[name='agree']");
    By continueBtn = By.cssSelector("#content input[type='submit']");
    By emailErrorMessage = By.xpath(
    	    "//div[contains(@class,'text-danger') and contains(text(),'E-Mail Address does not appear to be valid!')]"
    	);

    public void goToRegisterPage() {

        WaitUtils wu = new WaitUtils(driver);

        wu.waitForElementClickable(Account);
        driver.findElement(Account).click();

        wu.waitForElementClickable(registerOption);
        driver.findElement(registerOption).click();
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void enterTelephone(String value) {
        driver.findElement(telephone).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void enterConfirmPassword(String value) {
        driver.findElement(confirmPassword).sendKeys(value);
    }

    public void selectNewsletterYes() {
        driver.findElement(newsletterYes).click();
    }

    public void selectNewsletterNo() {
        driver.findElement(newsletterNo).click();
    }

    public void acceptPrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
    
    public String getEmailValidationMessage() {
        return driver.findElement(email).getAttribute("validationMessage");
    }
    
    public String getEmailErrorMessage() {
        return driver.findElement(emailErrorMessage).getText();
    }
    
}