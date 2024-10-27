package sprint6_Test_Rajesh;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.*;

public class S6_054_Add_Product  extends BaseClass {
	@Parameters({"browser","mode"})
	@BeforeMethod
	public void browser(String browser,String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("true")) {
			gridExecution(browser);

		}else  {
			browserInitiate(browser);
		}

	}


	@Parameters({"userName","password"})
	@Test(retryAnalyzer = RetryEvent.class)
	public void testCase_S6_054_Add_Product(String userName,String password) throws InterruptedException {

		SaleforceLogin login = new SaleforceLogin(driver);
		login.saleForceLogin(userName,password);
		S6_54_AddProductNewCase aP = new S6_54_AddProductNewCase(driver);
		aP.addProduct();

	}

}
