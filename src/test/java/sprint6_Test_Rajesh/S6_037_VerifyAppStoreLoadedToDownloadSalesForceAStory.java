package sprint6_Test_Rajesh;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_037_VerifyAppStoreLoadedToDownloadSalesForceAStory  extends BaseClass {
	@BeforeMethod
	public void browser() {
		browserInitiate("chrome");
	}
	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_037_VerifyAppStoreLoadedToDownloadSalesForceAStory() throws InterruptedException {

		browserInitiate("chrome");
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		S6_37_VerifyAppStoreLoadedToDownloadSalesForceAStory method1 = new S6_37_VerifyAppStoreLoadedToDownloadSalesForceAStory(driver);
		
		method1.VerifyAppStore();
	}

}
