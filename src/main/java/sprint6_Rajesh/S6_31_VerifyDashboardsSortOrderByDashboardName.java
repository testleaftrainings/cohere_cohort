package sprint6_Rajesh;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6_31_VerifyDashboardsSortOrderByDashboardName extends BaseClass {

	public S6_31_VerifyDashboardsSortOrderByDashboardName(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}


	public void s6_031_verifyDashboardsSortOrderByDashboardName() throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//		Click on the toggle menu button from the left corner

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']")))).click();


		// Click View All and click Dashboards from App Launcher

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();


		WebElement dashboarEle = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='All Items']//following::p[text()='Dashboards']")))); 

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",dashboarEle);

		//		Click on the Dashboards tab 

		dashboarEle.click();

		//		Click the sort arrow in the Dashboard Name.
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@title='New Dashboard']//following::thead//a)[1]//span[@title='Dashboard Name']")))).click();

		List<WebElement> rawNameListEle= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table//following::tr//th")));
		WebElement findElement = driver.findElement(By.xpath("(//table//following::td[@data-label='Description'][1])"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement);
		int prev =0;
		int k =1;

		while (true) {

			do {
				findElement.sendKeys(Keys.ARROW_DOWN);
				k++;
			}
			while(k<rawNameListEle.size());

			Thread.sleep(2000);

			rawNameListEle= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table//following::tr//th")));
			if(rawNameListEle.size()!=prev) {
				prev=rawNameListEle.size();

			}else {
				break;
			}

		}
		List<String> rawNameList = getAllText(rawNameListEle);

		//		Verify the Dashboard displayed in ascending order by Dashboard name.

		List<String> copyList = new ArrayList<>(rawNameList);
		Collections.sort(copyList,String.CASE_INSENSITIVE_ORDER);

		if (rawNameList.equals(copyList)) {
			Assert.assertTrue(true);

		}else {
			Assert.assertTrue(false);
		}

	}


	public  List<String> getAllText(List<WebElement> rawNameListEle) {

		List<String> namesList = new ArrayList<String>();
		for (WebElement element : rawNameListEle) {
			namesList.add(element.getText());  
		}
		return namesList;
	}


}
