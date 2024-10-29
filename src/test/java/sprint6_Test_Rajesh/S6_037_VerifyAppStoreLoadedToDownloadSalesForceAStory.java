package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_037_VerifyAppStoreLoadedToDownloadSalesForceAStory  extends BaseClass {
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
	@Test(retryAnalyzer = RetryEvent.class,enabled = true)
	public void testCase_S6_037_VerifyAppStoreLoadedToDownloadSalesForceAStory(String userName,String password) throws InterruptedException {

	
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);
		S6_37_VerifyAppStoreLoadedToDownloadSalesForceAStory method1 = new S6_37_VerifyAppStoreLoadedToDownloadSalesForceAStory(driver);
		
		method1.VerifyAppStore();
	}

}
