package sdet_FirstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EditOrder {
	
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void editOrderMthd() throws InterruptedException
	{
		driver.get("https://login.salesforce.com/?locale=in ");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span//p[text()='Service Console']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement select1 =driver.findElement(By.xpath("//div//input[@aria-label='Select item 1']/following::span"));
		action.moveToElement(select1).perform();
		select1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@role=\"gridcell\"]//a[@role='button'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@role='menuitem'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='Testleaf Software']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@title='Clear Selection'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='00000133']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		WebElement msg =driver.findElement(By.xpath("//div[@role='alert']//span[@data-aura-class='forceActionsText']"));
		System.out.println(msg.getText());
		
		
		
		
	}
	
	@AfterMethod
	public void aftMethod()
	{
		driver.quit();
	}

}
