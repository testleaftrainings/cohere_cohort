package jiraSaleforceAssessment;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryEvent implements IRetryAnalyzer  {
	private int retryStartCount=0;
	private int retryEndCount=3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retryStartCount< retryEndCount) {
			retryStartCount++;
			return true;
		}
		return false;
	}

}
