package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.AddProductWithOpportunity;
import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_053_AddProductWithOpportunity  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_053_verify_AddProductWithOpportunity() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		AddProductWithOpportunity aPWO = new AddProductWithOpportunity(driver);
		aPWO.addProduct();
	}

}
