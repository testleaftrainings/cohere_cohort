package sprint6_Test_Rajesh;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sprint6_Rajesh.BaseClass;
import sprint6_Rajesh.NBATest;
import sprint6_Rajesh.RetryEvent;


public class NBATestCase extends BaseClass{
	@Parameters({"browser","mode"})
	@BeforeMethod
	public void browser(String browser,String mode) throws MalformedURLException {
		if (mode.equalsIgnoreCase("true")) {
			gridExecution(browser);

		}else {
			browserInitiate(browser);
		}
	}

	
	@Test (retryAnalyzer = RetryEvent.class)
	public void testCase_NBA() throws InterruptedException, IOException {
		
		NBATest nB = new NBATest(driver);
		nB.verifyExp();


	}

}
