package sprint6_Test_Rajesh;

import org.testng.annotations.Test;

import sprint6_Rajesh.*;




public class S6_019_Create_Contact extends BaseClass{


	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_019_Create_Contact() throws InterruptedException {
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		S6_19_CreateContact cC =	new S6_19_CreateContact(driver);
		cC.s6_019_Create_Contact();
	}
}
