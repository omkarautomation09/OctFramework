package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listener.TestListener;
import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import retry.RetryAnalyzer;

//@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	@DataProvider(name ="logindata")
	public Object [][] getdata() throws IOException{
		
			String path = System.getProperty("user.dir")+"/src/test/resources/login.xlsx";
			return ExcelUtils.getData(path,"Sheet1");
			/*{"omkarmg99@grr.la", "Omkar@0921"},   // valid case
            {"omkarmg99@grr.la", "wrongpass"},             // invalid password
            {"", ""}, //empty userame and password
            {"","Omkar@0921"},//empty username and valid passowrd
            {"omkarmg99@grr.la"," "},//valid user name and empty pasword 
            {"omkarmg6699@trr.la","abcdefghi"}//invalid user and invalid password 
            */
			
		
	}
	
	@Test (dataProvider = "logindata")
	public void logintest(String email,String password) {
		LoginPage lp = new LoginPage(getDriver());
		lp.goToLoginPage();
		lp.login(email, password);
		
		//Valid Login
		if(email.equals("omkarmg99@grr.la") && password.equals("Omkar@0921") ) {
			 Assert.assertTrue(
					 getDriver().getCurrentUrl().contains("account/account"),
	                    "Valid login failed");
		}
		
		else {
			
			
			
			Assert.assertTrue(getDriver().getPageSource().contains("No match for E-Mail Address and/or Password"),"Warning message not displayed");
		}
		
		// Assert.assertTrue(false);
		
		}
	/*public void validlogintest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.login("omkarmg99@grr.la", "Omkar@0921");
		
		Assert.assertTrue(driver.getTitle().contains("My Account"));
	}
	
	@Test
	public void invalidPasswordTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.login("omkarmg99@grr.la", "asdfghcv");
		
		Assert.assertTrue(driver.getPageSource().contains("Warning"));
		
	}

	@Test
	public void emptyLoginTest() {LoginPage lp = new LoginPage(driver);
	lp.goToLoginPage();
	lp.login("", "");
	
	Assert.assertTrue(driver.getPageSource().contains("Warning"));
	}*/
	

	

}
