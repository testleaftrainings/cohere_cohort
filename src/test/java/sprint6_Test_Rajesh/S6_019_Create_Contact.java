package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;


public class S6_019_Create_Contact extends BaseClass{
	@Parameters({"browser","mode"})
	@BeforeMethod
	public void browser(String browser,String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("true")) {
			gridExecution(browser);

		}else {
			browserInitiate(browser);
		}

	}
	
	@Parameters({"password","userName"})
	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_019_Create_Contact(String userName,String password) throws InterruptedException {
		
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);
		S6_19_CreateContact cC =	new S6_19_CreateContact(driver);
		cC.s6_019_Create_Contact();
	}
}
