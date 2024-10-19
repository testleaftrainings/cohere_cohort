package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.AddProductNewCase;
import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_054_Add_Product  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_054_Add_Product() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		AddProductNewCase aP = new AddProductNewCase(driver);
		aP.addProduct();

	}

}
