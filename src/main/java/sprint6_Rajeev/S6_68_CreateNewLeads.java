package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_068_CreateNewLeads {
	
	@Test
	public void s6_068_CreateNewLeads() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

//		Login to https://login.salesforce.com 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

//			Click on the toggle menu button from the left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AppLauncher).build().perform();

		driver.executeScript("arguments[0].click()", AppLauncher);

//			Click View All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		// Click on the Leads tab
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Leads']")).click();
		
		// Click on the New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		// Select the Salutation as 'Mr.'
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Salutation']//following::button[@name='salutation']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(""));
		
		// Edited
		
		
	}

}
