package sprint6_Rajeev;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;


public class DeleteDashboard {

	
	@Test
	public void deleteDashboard() throws InterruptedException
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
		Thread.sleep(7000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		Thread.sleep(7000);
	
		//Click on Dashboard tab 
		WebElement dashboardLink = driver.findElement(By.xpath("//a[@title='Dashboards']"));
		driver.executeScript("arguments[0].click();", dashboardLink);
		 Thread.sleep(2000);
		 // search for Dashboard
		WebElement dashboardSearchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search recent dashboards...')]"));
		dashboardSearchBox.click();
		dashboardSearchBox.sendKeys("Rajeev Dashboard");
		Thread.sleep(2000);
		
		//Delete Dashbaord
		
		WebElement actionIcon= driver.findElement(By.xpath("//span[contains(@class,'highlightSearchText')]/following::td[last()]"));
		actionIcon.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'highlightSearchText')]/following::span[text()='Delete']")).click();
		Thread.sleep(2000);
		
		//Confirm delete
		WebElement confirmDelete= driver.findElement(By.xpath("//div[contains(text(),'Are you sure you want to delete this dashboard?')]/following::span[text()='Delete']"));
		confirmDelete.click();
		Thread.sleep(2000);
		//Verify Dashbaord deleted
		
		 // search for Dashboard
		WebElement dashboardSearchBoxAgain = driver.findElement(By.xpath("//input[contains(@placeholder,'Search recent dashboards...')]"));
		dashboardSearchBoxAgain.click();
		Thread.sleep(2000);
		dashboardSearchBoxAgain.clear();
		Thread.sleep(2000);
		dashboardSearchBoxAgain.sendKeys("Rajeev Dashboard");
		Thread.sleep(2000);
		
		java.util.List<WebElement> results = driver.findElements(By.xpath("//table[@role='grid']//tr"));
		Thread.sleep(2000);
	    Assert.assertTrue(results.isEmpty());
		

		}
	
	
	
}
