package sprint6_Rajesh;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class S6_70CreateLeadsWithoutMandatoryFields extends BaseClass {

	public S6_70CreateLeadsWithoutMandatoryFields(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public void s6_70_Create_Leads_Without_Mandatory_Fields() throws InterruptedException {
		// TODO Auto-generated method stub


		//		Click view All and click Sales from App Launcher
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='App Launcher']")))).click();


		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();


		WebElement sale = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[text()='Sales']"))));
		sale.click();

		// Click on Leads tab 
		Thread.sleep(2000);
		WebElement moreTab = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='App Launcher']//following::a[4]"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreTab);



		//		Click on New button
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@title='New']")))).click();

		//		Select Salutation as 'Mr'

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Salutation']//following::button[1]")))).click();


		driver.findElement(By.xpath("//span[@title='Mr.']")).click();


		//		Enter the First Name as 'Ganesh'

		driver.findElement(By.xpath("//label[text()='Salutation']//following::input[1]")).sendKeys("Ganesh");


		//		Enter CompanyName as 'TestLeaf'

		driver.findElement(By.xpath("//label[text()='Salutation']//following::input[4]")).sendKeys("Ganesh");


		//		click Save

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		//		Verify the Alert message (Complete this field) displayed for the Last Name
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='New Case']/following::a"))));
		List<WebElement> warningElements = driver.findElements(By.xpath("//h2[text()='New Case']/following::a"));

		for (WebElement message  : warningElements) {
			String text = message .getText();
			if (text.contains("Name")) {
				Assert.assertFalse(true);
			}
		}

	}
}
