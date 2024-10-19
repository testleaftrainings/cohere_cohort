package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.CreateContact;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;



public class S6_019_Create_Contact extends BaseClass{


	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_019_Create_Contact() throws InterruptedException {
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		CreateContact cC =	new CreateContact(driver);
		cC.s6_019_Create_Contact();
	}
}
