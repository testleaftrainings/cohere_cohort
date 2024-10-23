package sprint6_Rajesh;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryEvent implements IRetryAnalyzer  {
	private int retryStartCount=0;
	private int retryEndCount=5;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retryStartCount< retryEndCount) {
			retryStartCount++;
			return true;
		}
		return false;
	}

}
