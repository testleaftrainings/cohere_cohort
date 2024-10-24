package sprint6_Rajeev;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;


public class BoardExamShedule {

	
	@Test
	public void editEntity() throws InterruptedException
	{

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
		driver.manage().window().maximize();
		
		//Step 1: Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);

		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		Thread.sleep(5000);

		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);

		//Click on legalEntities tab 
		WebElement legalEntities = driver.findElement(By.xpath("//a[contains(@data-label,'Legal Entities')]"));
		driver.executeScript("arguments[0].click();", legalEntities);
		 Thread.sleep(10000);
		 
		 
		 // search for Dashboard
		WebElement dashboardSearchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list...')]"));
		dashboardSearchBox.click();
		dashboardSearchBox.sendKeys("Salesforce Automation by Rajeev");
		Thread.sleep(2000);
		dashboardSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		//Delete legalEntities
		WebElement actionIcon= driver.findElement(By.xpath("//a[contains(text(),'Salesforce Automation by Rajeev')]/following::td[last()]"));
		actionIcon.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Salesforce Automation by Rajeev')]/following::a[@title='Delete']")).click();
		Thread.sleep(2000);
		
		//Confirm delete
		WebElement confirmDelete= driver.findElement(By.xpath("//div[contains(text(),'Are you sure you want to delete this legal entity?')]/following::span[text()='Delete']"));
		confirmDelete.click();
		Thread.sleep(2000);
		
		//Verify legalEntities deleted
		 // search for legalEntities to verify if deleted
		WebElement dashboardSearchBoxAgain = driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list...')]"));
		dashboardSearchBoxAgain.click();
		Thread.sleep(2000);
		dashboardSearchBoxAgain.clear();
		Thread.sleep(2000);
		dashboardSearchBoxAgain.sendKeys("Salesforce Automation by Rajeev");
		Thread.sleep(2000);
		dashboardSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		java.util.List<WebElement> results = driver.findElements(By.xpath("//table[@role='grid']//tr"));
		Thread.sleep(2000);
	    Assert.assertTrue(results.size()<2);
	    
	    
		java.util.List<WebElement> DeletedLegalEntity = driver.findElements(By.xpath("//a[contains(text(),'Salesforce Automation by Rajeev')]"));
		Assert.assertTrue(DeletedLegalEntity.isEmpty());
		Thread.sleep(2000);
		

		}
	
	
	
}
