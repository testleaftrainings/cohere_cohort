package sprint6_Test_Rajesh;

import org.testng.annotations.Test;

import sprint6_Rajesh.*;



public class S6_007_DeleteWorkTypeGroup  extends BaseClass {

	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_007_DeleteWorkTypeGroup() throws InterruptedException {
	

        SaleforceLogin login = new SaleforceLogin(driver);  
        login.saleForceLogin();
        
        S6_07_DeleteWorkTypeGroup deleteWorkTypeGroup = new S6_07_DeleteWorkTypeGroup(driver);
        deleteWorkTypeGroup.s6_007_Delete_Work_Type_Group();

	}
	
}