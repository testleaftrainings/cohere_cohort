package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;


public class S6_013_Create_Case_Without_Mandatory_Fields extends BaseClass{
	
	@Parameters({"browser","mode"})
	@BeforeMethod
	public void browser(String browser,String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("true")) {
			gridExecution(browser);

		}else {
			browserInitiate(browser);
		}
	}

	@Parameters({"userName","password"})
	@Test (retryAnalyzer = RetryEvent.class,enabled = true)

	public void testCase_S6_013_Create_Case_Without_Mandatory_Fields(String userName,String password) throws InterruptedException {

		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);

		S6_13CreateCaseWithoutMandatoryFields cCWMF = new S6_13CreateCaseWithoutMandatoryFields(driver); 
		cCWMF.s6_013_Create_Case_Without_Mandatory_Fields();
	}
}
