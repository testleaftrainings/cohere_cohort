package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;
import jiraSaleforceAssessment.VerifyDashboardsSortOrderByDashboardName;

public class S6_031_verify_Dashboards_SortOrder_By_DashboardName  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_031_verify_Dashboards_SortOrder_By_DashboardName() throws InterruptedException {
	

        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin();
        
        VerifyDashboardsSortOrderByDashboardName vF=   new VerifyDashboardsSortOrderByDashboardName(driver);
        vF.s6_031_verifyDashboardsSortOrderByDashboardName();
       
	}
	
}
