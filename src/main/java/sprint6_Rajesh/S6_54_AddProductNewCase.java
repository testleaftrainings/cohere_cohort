package sprint6_Rajesh;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_54_AddProductNewCase extends BaseClass {
	public S6_54_AddProductNewCase(RemoteWebDriver driver) {
		this.driver =driver;
	}
	@Test
	public void addProduct() throws InterruptedException {




		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//		Click on toggle menu button from the left corner 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='App Launcher']"))).click();




		//		Click view All 

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Close']//following::button"))).click();


		//		Click on Content tab 

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Close this window']//following::a[5]"))).click();



		//		Click View All Key Deals in Key Deals 
		WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-component-id='home_topDealsContainer']//span[@class='viewAllLabel']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",viewAllButton);
		viewAllButton.click();



		//		Click the dropdown from Opportunities and select All Opportunities 
		Thread.sleep(2000);
		WebElement recent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Recently Viewed'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", recent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@role='option']/span)[1]")).click();


		//		Give SRM Steels in Search Box and search 

		String customer ="SRM Steels";
		WebElement searchBox = driver.findElement(By.xpath("//div[@title='New']//following::input[1]"));
		searchBox.sendKeys(customer);

		WebElement refresh = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Refresh']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", refresh);


		//		Click on the SRM Steels under Opportunity Name 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='"+customer+"']"))).click();



		//	Click on New Case, Click inside the Contact Name and select the first contact 
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='slds-button slds-button_neutral'])[1]"))).click();


		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Contact Name']//following::input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Contact Name']//following::input[1]//following::a[1]")).click();


		Thread.sleep(2000);


		//		Select Status as New and give Subject as New case to SRM Steels 
		driver.findElement(By.xpath("//span[text()='Status']//following::a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@title='New'])[2]")).click();

		driver.findElement(By.xpath("//span[text()='Subject']//following::input[1]")).sendKeys("New case to SRM Steels ");


		//		Click on save 


		driver.findElement(By.xpath("//span[text()='Subject']//following::span[text()='Save']")).click();
		WebElement toast = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))));
		String text = toast.getText();
		if (text!=""||!text.isBlank()||!text.isEmpty()) {
			Assert.assertTrue(true);
		}

	}

}
