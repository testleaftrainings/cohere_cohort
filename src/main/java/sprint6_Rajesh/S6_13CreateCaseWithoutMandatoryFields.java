package sprint6_Rajesh;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6_13CreateCaseWithoutMandatoryFields extends BaseClass {

	public S6_13CreateCaseWithoutMandatoryFields(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public void s6_013_Create_Case_Without_Mandatory_Fields() throws InterruptedException {
		// TODO Auto-generated method stub
		

		//		Click view All and click Sales from App Launcher
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='App Launcher']")))).click();


		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();


		WebElement sale = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[text()='Sales']"))));
		sale.click();

		//		Click on Cases tab 
		Thread.sleep(2000);
		WebElement moreTab = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='More']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreTab);

		
		WebElement casesTab = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",casesTab);

		//		Click on New button
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@title='New']")))).click();


		//		Choose Contact Name from DropDown
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Contact Name']/following::input[1]")))).click();


		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@title='Recent Contacts']/following::span[1]")))).click();;


		//		Select status as None
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Status']/following::div[1]")))).click();


		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@title='--None--']")))).click();;


		//		Enter Subject as 'Testing' and description as 'Automation testing'
		Actions act=new Actions(driver);

		WebElement scrollToElement = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//label[text()='Internal Comments']"))));
		act.moveToElement(scrollToElement).perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Subject']/following::input[1]")))).sendKeys("Testing");

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Description Information']")))).click();
		WebElement description = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Description']/following::div[1]"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",description);

		description.click();
		description.sendKeys("Automation testing");
		

		//		Get the text of Error message Displayed and Verify the message

		List<WebElement> totalEle = driver.findElements(By.xpath("//h2[text()='New Case']/following::button"));
		int savePoistion =totalEle.size()-1;
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h2[text()='New Case']/following::button["+savePoistion+"]"))));
		save.click();
				
		List<WebElement> warningElements = driver.findElements(By.xpath("//h2[text()='New Case']/following::a"));

		for (WebElement message  : warningElements) {
			System.err.println("Error Message: " + message .getText());
		}

	}
}
