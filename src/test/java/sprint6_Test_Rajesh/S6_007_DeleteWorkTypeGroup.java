package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.BaseClass;
import sprint6_Rajesh.RetryEvent;
import sprint6_Rajesh.*;


public class S6_007_DeleteWorkTypeGroup  extends BaseClass {
	@Parameters({"browser","mode"})
	@BeforeMethod
	public void browser(String browser,String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("true")) {
			gridExecution(browser);

		}else {
			browserInitiate(browser);
		}

	}
	
	@Parameters({"userName","password"})
	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_007_DeleteWorkTypeGroup(String userName,String password) throws InterruptedException {

		
		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);
		S6_07_DeleteWorkTypeGroup deleteWorkTypeGroup = new S6_07_DeleteWorkTypeGroup(driver);
		deleteWorkTypeGroup.s6_007_Delete_Work_Type_Group();

	}

}
