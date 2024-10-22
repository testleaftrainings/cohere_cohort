package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sprint6_Rajesh.SaleforceLogin;
import sprint6_Rajesh.BaseClass;
import sprint6_Rajesh.RetryEvent;
import sprint6_Rajesh.S6_70CreateLeadsWithoutMandatoryFields;


public class S6_70_Create_Leads_Without_Mandatory_Fields extends BaseClass{
	@Parameters({"browser","mode"})
	@BeforeMethod
	public void browser(String browser,String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("true")) {
			gridExecution(browser);

		}else  {
			browserInitiate(browser);
		}

	}
	
	@Parameters({"password","userName"})	
	@Test (retryAnalyzer = RetryEvent.class)
	public void testCase_S6_70_Create_Leads_Without_Mandatory_Fields(String userName,String password) throws InterruptedException {

		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);
		S6_70CreateLeadsWithoutMandatoryFields s6_70 = new S6_70CreateLeadsWithoutMandatoryFields(driver); 
		s6_70.s6_70_Create_Leads_Without_Mandatory_Fields();
	}
}
