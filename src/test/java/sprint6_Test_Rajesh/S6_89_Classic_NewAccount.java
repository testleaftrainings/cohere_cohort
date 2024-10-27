package sprint6_Test_Rajesh;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.BaseClass;
import sprint6_Rajesh.RetryEvent;
import sprint6_Rajesh.S6_89_SalesForce_Classic_NewAccount;
import sprint6_Rajesh.SaleforceLogin;


public class S6_89_Classic_NewAccount extends BaseClass{
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
	@Test (retryAnalyzer = RetryEvent.class)
	public void testCase_S6_89_SalesForce_Classic_NewAccount(String userName,String password) throws InterruptedException, IOException {

		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);
		S6_89_SalesForce_Classic_NewAccount newAcc = new S6_89_SalesForce_Classic_NewAccount(driver);
		newAcc.classic_NewAccount();
	}
	
}
