package sprint6_Test_Rajesh;

import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_053_AddProductWithOpportunity  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_053_verify_AddProductWithOpportunity() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		S6_53_AddProductWithOpportunity aPWO = new S6_53_AddProductWithOpportunity(driver);
		aPWO.addProduct();
	}

}
