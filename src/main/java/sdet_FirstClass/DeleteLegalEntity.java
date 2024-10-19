package sdet_FirstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeleteLegalEntity {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void deleteLegalMethod() throws InterruptedException
	{
		
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
		Actions action = new Actions(driver);
		WebElement legal = driver.findElement(By.xpath("//span//p[text()='Legal Entities']"));
		action.moveToElement(legal).click().perform();
		Thread.sleep(2000);
		WebElement search =driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		search.sendKeys("Salesforce Automation by Gokulakrishnan");
		action.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(2000);
		
		WebElement modified = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
		action.moveToElement(modified).perform();
		Thread.sleep(5000);
		modified.click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@data-aura-class=\"forceVirtualAction\"]//a")).click();
		Thread.sleep(5000);
		WebElement del =driver.findElement(By.xpath("//li//div[@title='Delete']"));
		action.moveToElement(del).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title=\"Delete\"]")).click();
		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]//following::a/div")).getText();
		System.out.println(result);
	}

}
