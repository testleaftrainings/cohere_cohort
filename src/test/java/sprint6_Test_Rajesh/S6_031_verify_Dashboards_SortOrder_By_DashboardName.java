package sprint6_Test_Rajesh;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_031_verify_Dashboards_SortOrder_By_DashboardName  extends BaseClass {
	@BeforeMethod
	public void browser() {
		browserInitiate("chrome");
	}
	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_031_verify_Dashboards_SortOrder_By_DashboardName() throws InterruptedException {
		browserInitiate("chrome");

        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin();
        
        S6_31_VerifyDashboardsSortOrderByDashboardName vF=   new S6_31_VerifyDashboardsSortOrderByDashboardName(driver);
        vF.s6_031_verifyDashboardsSortOrderByDashboardName();
       
	}
	
}
