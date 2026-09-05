package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		}
	
	By searchBox = By.name("search");

    By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
    
    By categoryDropdown = By.name("category_id");

    By advancedSearchBtn = By.id("button-search");
    
    By subCategoryCheckBox = By.name("sub_category");
    
    By descriptionCheckBox = By.name("description");
    
    
    
    
    public void searchProduct(String product) {

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox).sendKeys(product);

        driver.findElement(searchBtn).click();
        
    }
    
    public void selectCategory(String category) {
    	
    	Select select = new Select(driver.findElement(categoryDropdown));
    	select.selectByVisibleText(category);
    	
    	}
    
    public void clickAdvancedSearchButton() {

        driver.findElement(advancedSearchBtn).click();
    }
    
    public void clickSubCategory() {

        driver.findElement(subCategoryCheckBox).click();

    }
    public void clickDescriptionCheckBox() {

        driver.findElement(descriptionCheckBox).click();
    }
    
    public boolean isProductDisplayed(String product) {

        By productResult = By.linkText(product);

        return driver.findElement(productResult).isDisplayed();
    }
	
	
	
	
	
	

}
