package sdet_FirstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewOpportunity {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void newOppMethod() throws InterruptedException
	{
		SoftAssert sAssert = new SoftAssert();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		WebElement opp = driver.findElement(By.xpath("//span/p[text()='Opportunities']"));
		Actions action = new Actions(driver);
		action.moveToElement(opp).perform();
		opp.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(5000);
		String name ="Salesforce Automation by Gokulakrishnan";
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("12/10/2024");
		Thread.sleep(5000);
		
		WebElement dropdown = driver.findElement(By.xpath("//records-record-layout-item[@field-label='Stage']//button[@role='combobox']"));
		dropdown.click();
		
		driver.findElement(By.xpath("//div//*[@aria-label='Stage']/lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]//following::a/div")).getText();
		System.out.println(result);
		sAssert.assertEquals(result, name, "Not Matching");
		sAssert.assertAll();
	}
	
	@AfterTest
	public void afMethod() {
		driver.quit();
	}


}
