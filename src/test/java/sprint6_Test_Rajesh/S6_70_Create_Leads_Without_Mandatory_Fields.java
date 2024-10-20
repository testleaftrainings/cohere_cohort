package sprint6_Test_Rajesh;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sprint6_Rajesh.SaleforceLogin;
import sprint6_Rajesh.BaseClass;
import sprint6_Rajesh.RetryEvent;
import sprint6_Rajesh.S6_70CreateLeadsWithoutMandatoryFields;


public class S6_70_Create_Leads_Without_Mandatory_Fields extends BaseClass{
	@BeforeMethod
	public void browser() {
		browserInitiate("chrome");
	}
	@Test (retryAnalyzer = RetryEvent.class)
	public void testCase_S6_70_Create_Leads_Without_Mandatory_Fields() throws InterruptedException {
		browserInitiate("chrome");
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin();
		S6_70CreateLeadsWithoutMandatoryFields s6_70 = new S6_70CreateLeadsWithoutMandatoryFields(driver); 
		s6_70.s6_70_Create_Leads_Without_Mandatory_Fields();
	}
}
