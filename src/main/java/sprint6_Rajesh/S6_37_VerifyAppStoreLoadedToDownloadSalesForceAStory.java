package sprint6_Rajesh;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class S6_37_VerifyAppStoreLoadedToDownloadSalesForceAStory extends BaseClass{

	public S6_37_VerifyAppStoreLoadedToDownloadSalesForceAStory(WebDriver driver) {
		this.driver=driver;
	}
	@Test
	public void VerifyAppStore() throws InterruptedException {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//		Click on the sliding icon until """"Get started with Einstein bots"""" is displayed

		Thread.sleep(5000);
		List<WebElement> labelEle = driver.findElements(By.xpath("(//div[@id='setupComponent']//following::h2/span)"));

		int count = 1;
		for (int i = 0; i < labelEle.size(); i++) {
			int temp =i+1;
			WebElement label = driver.findElement(By.xpath("(//div[@id='setupComponent']//following::h2/span)["+temp+"]"));
			String labelNa = label.getText();

			if (labelNa.equalsIgnoreCase("Get Started with Einstein Bots")) {


				//				Click on Get Started link
				Thread.sleep(5000);
				WebElement getStart = driver.findElement(By.xpath("(//button[@title='Get Started'])["+count+"]"));
				getStart.click();


				break;

			}else if(count ==3){
				count =1;
				driver.findElement(By.xpath("//div[@class='leftScroll']//following::button[1]")).click();
				break;
			}
			count ++;
		}


		//		Click on the sliding icon until """"Einstein Bot Trails"""" is displayed  && Click on the Einstein Bot Trails.

		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='setupComponent']//following::h2[text()='Einstein Bots Trails']")))).click();


		Windowhandle(driver, 1);


		Shadow shadow = new Shadow(driver);



		Thread.sleep(2000);
		//scroll the element and click
		WebElement trail = shadow.findElementByXPath("//span[text()='Products']");
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",trail);
		trail.click();


		// Click on the 'Partner Apps and Experts'

		WebElement partner = shadow.findElementByXPath("//div[@id='global-nav-container']//following::span[text()='Partner Apps & Experts']");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",partner);
		partner.click();


		//	Click on the Find an app'

		driver.findElement(By.xpath("(//main[@id='main-content']//following::a)[2]")).click();

		//		Search for 'SalesforceA

		shadow.findElementByXPath("//input[@title='Search AppExchange']").sendKeys("SalesforceA");
		Thread.sleep(2000);
		shadow.findElementByXPath("//div[@data-item='SalesforceA']").click();


		//		Click on the 'SalesforceA Connected Apps Administration'
		Thread.sleep(2000);
		shadow.findElementByXPath("//a[text()='SalesforceA Connected Apps Administration']").click();

		//		Verify  'SalesforceA Connected Apps Administration' is displayed with Get It Now button.

		Thread.sleep(2000);

		boolean title = shadow.findElementByXPath("//h1[text()='SalesforceA Connected Apps Administration']").isDisplayed();
		boolean button = shadow.findElementByXPath("//button[@class='element variant-primary']").isDisplayed();
		if (title&&button) {
			Assert.assertTrue(title);
		}else {
			Assert.assertTrue(false);
		}
		driver.quit();
	}

	public void Windowhandle(WebDriver driver,int a) {

		Set<String> allWindowHandles = driver.getWindowHandles();

		List <String> window =new ArrayList<String>(allWindowHandles);

		driver.switchTo().window(window.get(a));
		allWindowHandles.clear();
		window.clear();
	}

}
