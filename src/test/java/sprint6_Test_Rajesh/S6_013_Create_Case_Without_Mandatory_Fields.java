package sprint6_Test_Rajesh;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;


public class S6_013_Create_Case_Without_Mandatory_Fields extends BaseClass{
	@BeforeMethod
	public void browser() {
		browserInitiate("chrome");
	}
	@Test (retryAnalyzer = RetryEvent.class)

	public void testCase_S6_013_Create_Case_Without_Mandatory_Fields() throws InterruptedException {
		
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();

		S6_13CreateCaseWithoutMandatoryFields cCWMF = new S6_13CreateCaseWithoutMandatoryFields(driver); 
		cCWMF.s6_013_Create_Case_Without_Mandatory_Fields();
	}
}
