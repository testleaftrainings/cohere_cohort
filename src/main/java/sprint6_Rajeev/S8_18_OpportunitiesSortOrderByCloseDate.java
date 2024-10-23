package learning;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;


public class OpportunitiesSortOrderByCloseDate {

	
	@Test
	public void createAccount() throws InterruptedException
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
		Thread.sleep(2000);Thread.sleep(2000);
	
		//Click on Oppoertunities tab 
		 driver.findElement(By.xpath("//a[@title='Opportunities']")).click();
		 
		 // click Close Date sort
		WebElement sortCloseDate = driver.findElement(By.xpath("//span[@title='Close Date']"));
		driver.executeScript("arguments[0].click();", sortCloseDate);
		
		
		java.util.List<WebElement> messageElements = driver.findElements(By.xpath("//table[@role='grid']//tr/td[5]"));
	    ArrayList<String> messageList = new ArrayList<String>();
	    for (WebElement element : messageElements) {
	      messageList.add(element.getText());
	    }
	    
	    boolean sorted = Ordering.natural().isOrdered(messageList);
		
	    Assert.assertTrue(sorted);
		

		}
	
	
	
}
