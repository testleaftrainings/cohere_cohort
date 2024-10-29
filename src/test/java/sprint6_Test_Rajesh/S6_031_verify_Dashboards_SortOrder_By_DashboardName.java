package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_031_verify_Dashboards_SortOrder_By_DashboardName  extends BaseClass {
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
	@Test(retryAnalyzer = RetryEvent.class,enabled = true)
	public void testCase_S6_031_verify_Dashboards_SortOrder_By_DashboardName(String userName,String password) throws InterruptedException {


        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin(userName,password);
        
        S6_31_VerifyDashboardsSortOrderByDashboardName vF=   new S6_31_VerifyDashboardsSortOrderByDashboardName(driver);
        vF.s6_031_verifyDashboardsSortOrderByDashboardName();
       
	}
	
}
