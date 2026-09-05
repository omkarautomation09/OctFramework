package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ScreenshotUtils;

public class BaseTest {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }
	
	@BeforeMethod
	
	 @Parameters("browser")
	
public void setup(String browser) throws Exception{
		
		System.out.println("BROWSER RECEIVED = " + browser);
		
		 if (browser.equalsIgnoreCase("chrome")) {

	            WebDriverManager.chromedriver().setup();
	            driver.set(new ChromeDriver());


	        } 

	        	else if (browser.equalsIgnoreCase("edge")) {

	        	    System.setProperty(
	        	        "webdriver.edge.driver",
	        	        System.getProperty("user.dir") + "/drivers/msedgedriver.exe"
	        	    );

	        	    driver.set(new EdgeDriver());

	        } else {
	            throw new IllegalArgumentException("Browser not supported: " + browser);
	        }
		 
		 getDriver().manage().window().maximize();

		 ConfigReader cr = new ConfigReader();
		 getDriver().get(cr.getUrl());
	//driver.get("https://tutorialsninja.com/demo/");
}
	@AfterMethod
	
	public void tearDown(ITestResult result)
	        throws IOException {

	    // If test fails
	    if(result.getStatus() == ITestResult.FAILURE) {

	        ScreenshotUtils.captureScreenshot(
	        		getDriver(),
	                result.getName()
	        );
	    }

	    getDriver().quit();
	    driver.remove();
	}

}
