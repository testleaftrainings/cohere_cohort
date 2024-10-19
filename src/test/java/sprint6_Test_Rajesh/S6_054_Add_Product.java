package sprint6_Test_Rajesh;

import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_054_Add_Product  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_054_Add_Product() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		S6_54_AddProductNewCase aP = new S6_54_AddProductNewCase(driver);
		aP.addProduct();

	}

}
