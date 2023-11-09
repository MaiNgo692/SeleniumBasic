package automation.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pagelocator.TrizenFlightFactory;

public class TrizenFlight extends CommonBase{
	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver(CT_Account.webURL2);
	}
	
	@Test
	public void chooseDateTimeSuccessfully() {
		TrizenFlightFactory trizenFlight = new TrizenFlightFactory(driver);
		trizenFlight.chooseDateTime("28022024");
		
	}
	
	@Test
	public void findFlight() {
		TrizenFlightFactory trizenFlight = new TrizenFlightFactory(driver);
		trizenFlight.fillFlightFrom("Ha Noi");
		trizenFlight.fillFlightTo("Ho Chi Minh");
		trizenFlight.chooseDateTime("28032024");
		trizenFlight.plusPassengersAdult();
		trizenFlight.selectCoach("Business");
		trizenFlight.clickSearch();
	}
}
