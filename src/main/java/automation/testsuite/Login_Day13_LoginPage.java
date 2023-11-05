package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pagelocator.LoginPage;

public class Login_Day13_LoginPage extends CommonBase{
	@BeforeMethod
	public void openChorme() {
		driver = initDriverTest(CT_Account.webURL);
	}
	
	@Test( priority = 4 )
	public void loginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
		
	}
	
	@Test( priority = 3 )
	public void loginFail_IncorrectEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo1.com", "riseDemo");
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		
	}
	@Test ( priority = 2 )
	public void loginFail_IncorrectPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo1");
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}
	
	@Test ( priority = 1 )
	public void loginFail_IncorrectPass_IncorrectEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo1.com", "riseDemo1");
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeChorme() {
		quitDriver(driver);
	}
	
	
}
