package saleforceTestCase;

import org.testng.annotations.Test;

import jiraSaleforceAssessment.BaseClass;
import jiraSaleforceAssessment.DeleteWorkTypeGroup;
import jiraSaleforceAssessment.RetryEvent;
import jiraSaleforceAssessment.SaleforceLogin;

public class S6_007_DeleteWorkTypeGroup  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_007_DeleteWorkTypeGroup() throws InterruptedException {
	

        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin();
        
        DeleteWorkTypeGroup deleteWorkTypeGroup = new DeleteWorkTypeGroup(driver);
        deleteWorkTypeGroup.s6_007_Delete_Work_Type_Group();

	}
	
}
