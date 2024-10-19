package jiraSaleforceAssessment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyDashboardsSortOrderByDashboardName extends BaseClass {

	public VerifyDashboardsSortOrderByDashboardName(WebDriver driver) {
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
		Thread.sleep(2000);

		List<WebElement> rawNameListEle= driver.findElements(By.xpath("//table//following::tr/th"));
		List<String> rawNameList = getAllText(rawNameListEle);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@title='New Dashboard']//following::thead//a)[1]//span[@title='Dashboard Name']")))).click();

		Thread.sleep(5000);
		List<WebElement> sortNameListEle= driver.findElements(By.xpath("//table//following::tr/th"));


		//		Verify the Dashboard displayed in ascending order by Dashboard name.

		List<String> sortNameList = getAllText(sortNameListEle);


		if (!rawNameList.equals(sortNameList)) {
			Collections.sort(rawNameList,String.CASE_INSENSITIVE_ORDER);

			if (rawNameList.equals(sortNameList)) {
				org.testng.Assert.assertTrue(true);

			}else {
				org.testng.Assert.assertTrue(false);
			}
		} else {
			org.testng.Assert.assertTrue(false);
		}

	}


	public  List<String> getAllText(List<WebElement> rawNameListEle) {

		List<String> namesList = new ArrayList<>();
		for (WebElement element : rawNameListEle) {
			namesList.add(element.getText());  // Get text and add to namesList
		}
		return namesList;
	}


}
