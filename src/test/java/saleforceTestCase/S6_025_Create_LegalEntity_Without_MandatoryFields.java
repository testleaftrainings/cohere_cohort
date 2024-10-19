package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.CreateLegalEntityWithoutMandatoryFields;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_025_Create_LegalEntity_Without_MandatoryFields  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_025_createLegalEntityWithoutMandatoryFields() throws InterruptedException {
	

        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin();
        
        CreateLegalEntityWithoutMandatoryFields cLEWMF=   new CreateLegalEntityWithoutMandatoryFields(driver);
       
        cLEWMF.s6_025_createLegalEntityWithoutMandatoryFields(); 
	}
	
}
