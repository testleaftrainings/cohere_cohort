package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.CreateOpportunitywithoutmandatoryfields;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_CreateOpportunitywithoutmandatoryfields  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_CreateOpportunitywithoutmandatoryfields() throws InterruptedException {


		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		CreateOpportunitywithoutmandatoryfields cOW = new CreateOpportunitywithoutmandatoryfields(driver);
		cOW.saleForceStory();
	}

}
