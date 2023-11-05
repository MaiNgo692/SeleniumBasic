package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pagelocator.LoginPageALada;
import automation.pagelocator.SiginPageAlada;

public class LogInAlada_hw_Day14 extends CommonBase {
	@BeforeMethod
	public void openChorme() {
	}
	
	@Test(priority = 1)
	public void logInAladaSuccessfully() {
		LoginPageALada page = new LoginPageALada(driver);
		page.logInFunction("ngomai692@gmail.com","123456");
		assertEquals(true, driver.findElement(By.xpath("(//a[text()=\"Khóa học của tôi\"])[1]")).isDisplayed());
		System.out.println("Passed testcase");
	}
	
	@AfterMethod
	public void closeChorme() {
		quitDriver(driver);
	}
}
