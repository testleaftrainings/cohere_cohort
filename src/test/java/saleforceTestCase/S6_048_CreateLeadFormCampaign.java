package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.CreateLeadForCampaign_S048;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_048_CreateLeadFormCampaign  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_048_CreateLeadFormCampaign() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		CreateLeadForCampaign_S048 cLF = new CreateLeadForCampaign_S048(driver);
		cLF.salesForce();

	}

}
