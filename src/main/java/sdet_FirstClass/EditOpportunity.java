package sdet_FirstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditOpportunity {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void editOppMethod() throws InterruptedException
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
		String name ="Salesforce Automation by Gokulakrishnan";
		WebElement searchInput = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		searchInput.sendKeys(name);
		Thread.sleep(5000);
		action.moveToElement(searchInput).perform();
		searchInput.sendKeys(Keys.ENTER);
		
//		searchInput.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@role='gridcell']//a[@role='button']")).click();
		Thread.sleep(5000);
		WebElement edit = driver.findElement(By.xpath("//li//div[@title='Edit']"));
		action.moveToElement(edit).click().perform();
		Thread.sleep(5000);
		WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		closeDate.click();
		closeDate.clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("13/10/2024");
		Thread.sleep(5000);
		WebElement dropdown = driver.findElement(By.xpath("//records-record-layout-item[@field-label='Stage']//button[@role='combobox']"));
		dropdown.click();
		
		driver.findElement(By.xpath("//div//*[@aria-label='Stage']/lightning-base-combobox-item[@data-value='Perception Analysis']")).click();
		Thread.sleep(5000);
		WebElement delStat = driver.findElement(By.xpath("//force-custom-link-url[@title='Delivery Status']"));
		action.moveToElement(delStat).perform();
		WebElement desc = driver.findElement(By.xpath("//label[text()='Description']"));
		action.moveToElement(desc).perform();
		WebElement txtArea =driver.findElement(By.xpath("//textarea[@part='textarea']"));
		txtArea.clear();
		txtArea.sendKeys("SalesForce");
		
//		WebElement delivery = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']//span"));
		WebElement delivery = driver.findElement(By.xpath("(//label[text()='Delivery/Installation Status']//following::div//button)[1]"));
		action.moveToElement(delivery).perform();
		delivery.click();
		Thread.sleep(2000);
		WebElement status = driver.findElement(By.xpath("//span[@title='In progress']"));
		action.moveToElement(status).click().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		String msg= driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]")).getText();
		System.out.println(msg);
		
		//input[@name='CloseDate']

	}
	
//	@AfterTest
	public void afMethod() {
		driver.quit();
	}


}
