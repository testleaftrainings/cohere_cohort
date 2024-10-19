package sdet_FirstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.cucumber.java.After;

public class CreateAccount {
	ChromeDriver driver = new ChromeDriver();
	
	@Test
	public void createAccMthd() throws InterruptedException	
	{
//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();	
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span//p[text()='Sales']")).click();
		//Click on Accounts tab 
		Thread.sleep(5000);
		
		WebElement eleAccount =driver.findElement(By.xpath("//a[@title='Accounts']//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccount);
		Thread.sleep(5000);
		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(5000);
		//Enter 'your name' as account name
//		driver.findElement(By.xpath("//label[text()='Account Name']//following::div")).click();
//		driver.findElement(By.xpath("//label[text()='Account Name']//following::div")).sendKeys("Gokulakrishnan");
		
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Gokulakrishnan");
		
//		Thread.sleep(5000);
//		WebElement eleEmployee = driver.findElement(By.xpath("//label[text()='Employees']//following::div"));
//		driver.executeScript("arguments[0].scrollIntoView();", eleEmployee);
		Thread.sleep(5000);
		WebElement eleOwnership = driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
		Thread.sleep(5000);
		driver.executeScript("arguments[0].scrollIntoView();", eleOwnership);
		driver.executeScript("arguments[0].click();", eleOwnership);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]//following::span//span[text()='Private']")).click();
		driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		//Select Ownership as Public 
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


//

//
//
//Click on New button
//
//Enter 'your name' as account name
//
//Select Ownership as Public                                       
//
//Click save and verify Account name 
//
//Expected Result:
//Account should be created Successfully

}
