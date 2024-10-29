package sprint6_Test_Rajesh;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sprint6_Rajesh.SaleforceLogin;
import sprint6_Rajesh.BaseClass;
import sprint6_Rajesh.RetryEvent;
import sprint6_Rajesh.S6_71_CreateNewContract;


public class S6_71_Create_New_Contract extends BaseClass{
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
	@Test (retryAnalyzer = RetryEvent.class,groups = "createContract",enabled = true)
	public void testCase_S6_71_Create_New_Contract(String userName,String password) throws InterruptedException, IOException {

		SaleforceLogin login = new SaleforceLogin(driver);  
		login.saleForceLogin(userName,password);
		S6_71_CreateNewContract contract = new S6_71_CreateNewContract(driver);
		contract.newContract();

	}
}
