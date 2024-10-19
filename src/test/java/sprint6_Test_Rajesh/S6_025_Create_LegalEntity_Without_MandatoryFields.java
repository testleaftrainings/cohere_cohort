package sprint6_Test_Rajesh;

import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_025_Create_LegalEntity_Without_MandatoryFields  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_025_createLegalEntityWithoutMandatoryFields() throws InterruptedException {
	

        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin();
        
        S6_25_CreateLegalEntityWithoutMandatoryFields cLEWMF=   new S6_25_CreateLegalEntityWithoutMandatoryFields(driver);
       
        cLEWMF.s6_025_createLegalEntityWithoutMandatoryFields(); 
	}
	
}
