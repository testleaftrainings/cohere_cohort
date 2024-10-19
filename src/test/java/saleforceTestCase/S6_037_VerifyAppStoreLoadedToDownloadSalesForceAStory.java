package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;
import jiraSaleforceAssessment.VerifyAppStoreLoadedToDownloadSalesForceAStory;

public class S6_037_VerifyAppStoreLoadedToDownloadSalesForceAStory  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_037_VerifyAppStoreLoadedToDownloadSalesForceAStory() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		VerifyAppStoreLoadedToDownloadSalesForceAStory method1 = new VerifyAppStoreLoadedToDownloadSalesForceAStory(driver);
		
		method1.VerifyAppStore();
	}

}
