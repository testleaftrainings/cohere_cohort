package sprint6_Rajesh;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6_07_DeleteWorkTypeGroup extends BaseClass{

	public S6_07_DeleteWorkTypeGroup(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	public void s6_007_Delete_Work_Type_Group() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


//		Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']")))).click();
			
		
//		Click View All and click Work Type Groups from App Launcher
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@type='search']/input")))).sendKeys("Work Type Groups");
		
		
		
//		Click on the Work Type Group tab 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@title='All Items']//following::mark[text()='Work Type Groups']")))).click();

		
//		Search the Work Type Group 'Salesforce Automation by *Your Name*'
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")))).sendKeys("Salesforce Automation by Rajesh");

		
		Thread.sleep(2000);
//		Click on the Dropdown icon and Select Delete
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Show Actions']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",dropDown);
	
		WebElement deleteDrop = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='Delete']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",deleteDrop);
		
//		Click on the Delete option in the displayed popup window.
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='Delete']")))).click();
		
		
//		Verify Whether Work Type group is Deleted using Work Type Group Name
		WebElement toast = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))));
		String text = toast.getText();
		
	
		if (text=="Work Type Group \"Salesforce Automation by Rajesh\" was deleted. Undo") {
			System.out.println("Deleted Successfully ");
		}
		
	}
	
	
}
