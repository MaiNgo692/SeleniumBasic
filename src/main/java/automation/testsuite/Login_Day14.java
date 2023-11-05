package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pagelocator.LoginPageFactory;

public class Login_Day14 extends CommonBase{

	@BeforeMethod
	public void openChorme() {
		driver = initDriverTest(CT_Account.webURL);
	}
@Test(priority = 1)
public void loginSuccessfully() {
	LoginPageFactory page = new LoginPageFactory(driver);
	page.LoginFunction("admin@demo.com", "riseDemo");
	assertEquals(true, driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
	System.out.println("Passed testcase");
}

@Test ( priority = 2 )
public void loginFail_IncorrectPass() {
	LoginPageFactory page = new LoginPageFactory(driver);
	page.LoginFunction("admin@demo.com", "riseDemo1");
	assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	System.out.println("Passed testcase");
}
@Test ( priority = 3 )
public void loginFail_IncorrectPass_IncorrectEmail() {
	LoginPageFactory page = new LoginPageFactory(driver);
	page.LoginFunction("admin@demoincorect.com", "riseDemo");
	assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	System.out.println("Passed testcase");
}
@AfterMethod
public void closeChorme() {
	quitDriver(driver);
}
}
