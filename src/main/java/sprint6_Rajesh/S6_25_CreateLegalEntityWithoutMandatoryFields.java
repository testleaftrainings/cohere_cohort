package sprint6_Rajesh;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6_25_CreateLegalEntityWithoutMandatoryFields extends BaseClass {


	public S6_25_CreateLegalEntityWithoutMandatoryFields(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public void s6_025_createLegalEntityWithoutMandatoryFields() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//		Click on the toggle menu button from the left corner


		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']")))).click();



		//		Click View All and click Legal Entities from App Launcher

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();


		WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='All Items']//following::p[text()='Legal Entities']")))); 

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",ele);
		ele.click();

		//		Click on the Dropdown icon in the legal Entities tab
		Thread.sleep(5000);
		WebElement legalEntites = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']//following::a[@role='button'][1]"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",legalEntites);


		//		Click on New Legal Entity

		Thread.sleep(2000);
		WebElement eleClick = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='New Legal Entity']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",eleClick);
		//		Enter the Company name as 'Tetsleaf'.
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Information']//following::input[2]")))).sendKeys("Tetsleaf");

		//		Enter Description as 'SalesForce'.

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Information']//following::textarea[2]")))).sendKeys("SalesForce");

		//		Select Status as 'Active'
		Thread.sleep(2000);
		WebElement scrol = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Status']//following::button[1]"))));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",scrol);
		Thread.sleep(2000);
		scrol.click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Information']//following::button[1]//following::span[text()='Active']")))).click();

		//		Click on Save
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Information']//following::button[text()='Save']")))).click();


		//		Verify the Alert message (Complete this field) displayed for Name   
		Thread.sleep(2000);
		String text = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']/li/a")))).getText();
		System.err.println("Error: "+text);

	}

}
