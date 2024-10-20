package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyDashboardSubscribe {
@Test
public void dashboardSubscribe() {
	ChromeDriver driver = new ChromeDriver();
	//Step 1: Launch the salesforce app
	driver.get("https://login.salesforce.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Step 2: Login with the credentials
	driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Leaf$321");
	
	//Step 3: Click Login
	driver.findElement(By.id("Login")).click();
	
	//Step 4: Click on the App Laucher Icon left to Setup
	driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

	//Click view All and click Dashboards from App Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	WebElement eleDashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
	driver.executeScript("arguments[0].click();", eleDashboards);
	
	//Step : Search the Dashboard 'Salesforce Automation by *Your Name*
	driver.findElement(By.xpath("//lightning-icon[@icon-name='utility:search']//following-sibling::div//input")).sendKeys("Devipriya");

	//Step : Click on the Dropdown icon and Select Subscribe
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		driver.findElement(By.xpath("(//button//span[text()='Show actions'])[1]")).click();
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//span[text()='Subscribe']")).click();

	//Step : Select frequency as 'Daily' and Click on Save in the Edit Subscription popup window. 
	driver.findElement(By.xpath("//span[text()='Daily']")).click();
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	
	//Step : Verify Whether the dashboard is subscribed. 
	String subscribeTrue = driver.findElement(By.xpath("//th//a[contains(text(),'Devipriya')]//following::td[5]//span[@class='slds-assistive-text']")).getText();

	//Step : Expected Result: Dashboards should be subscribed Successfully 
	subscribeTrue.equals("True");
}
}
