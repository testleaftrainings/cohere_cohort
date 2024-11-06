package sprint6_Gokul;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClassicNewAccount81 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void newAccountMethod() throws Exception {

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li//a[text()='Accounts']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//td//input[@title='New']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td//label[text()='Account Name']//following::td//input)[1]"))
				.sendKeys("BootCamp Puppeteer_Gokulakrishnan1");
		driver.findElement(By.xpath("(//td//label[text()='Billing Street']//following::td//textarea)[1]"))
				.sendKeys("4th street");
		driver.findElement(By.xpath("(//td//label[text()='Billing City']//following::td//input)[1]"))
				.sendKeys("Coimbatore1");
		driver.findElement(By.xpath("(//td//label[contains(text(),'Billing Zip')]//following::td//input)[1]"))
				.sendKeys("642109");
		driver.findElement(By.xpath("(//td//label[contains(text(),'Billing State')]//following::td//input)[1]"))
				.sendKeys("Tamil Nadu1");
		driver.findElement(By.xpath("(//td//label[contains(text(),'Billing Country')]//following::td//input)[1]"))
				.sendKeys("India1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span//a[text()='Copy Billing Address to Shipping Address']")).click();

		driver.findElement(By.xpath("(//td//label[text()='SLA Expiration Date']//following::td//input)[1]"))
				.sendKeys("26/11/2024");
		driver.findElement(By.xpath("//td//input[@title='Save']")).click();
		try {
			driver.findElement(By.xpath("//input[@value='Save (Ignore Alert)']")).click();
		} catch (Exception e) {

		}
		SoftAssert sAssert = new SoftAssert();
		Thread.sleep(3000);
		Boolean entryCreated = driver.findElement(By.xpath("//span[contains(text(),'BootCamp Puppeteer_Gokul')]"))
				.isDisplayed();
		sAssert.assertEquals(entryCreated, true);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//li//a[text()='Accounts']")).click();
		Thread.sleep(3000);
		Boolean entryCreated1 = driver.findElement(By.xpath("//th//a[contains(text(),'BootCamp Puppeteer_Gokul')]"))
				.isDisplayed();
		sAssert.assertEquals(entryCreated1, true);
		sAssert.assertAll();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}