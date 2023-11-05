package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageALada {
	private WebDriver driver;
	
	@FindBy(id="txtLoginUsername")
	private WebElement txtLoginUsername;
	
	@FindBy(id="txtLoginPassword")
	private WebElement txtLoginPassword;
	
	@FindBy(xpath="//button[@type = \"submit\"]")
	private WebElement btnLogIn;
	public LoginPageALada(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void logInFunction( String email,String password ) {
		txtLoginUsername.clear();
		txtLoginUsername.sendKeys(email);
		txtLoginPassword.clear();
		txtLoginPassword.sendKeys(password);
		btnLogIn.click();
	}
}
