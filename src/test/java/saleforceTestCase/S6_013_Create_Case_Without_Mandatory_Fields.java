package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.CreateCaseWithoutMandatoryFields;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_013_Create_Case_Without_Mandatory_Fields extends BaseClass{

	@Test (retryAnalyzer = RetryEvent.class)

	public void testCase_S6_013_Create_Case_Without_Mandatory_Fields() throws InterruptedException {
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();

		CreateCaseWithoutMandatoryFields cCWMF = new CreateCaseWithoutMandatoryFields(driver); 
		cCWMF.s6_013_Create_Case_Without_Mandatory_Fields();
	}
}
