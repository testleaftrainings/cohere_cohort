package Sprint6_Gokul;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateCampaign42 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void deleteLegalMethod() throws InterruptedException {

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
		driver.findElement(By.xpath("//span//p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement campaign = driver.findElement(By.xpath("//a//span[text()='Campaigns']"));
		Actions action = new Actions(driver);
		action.moveToElement(campaign).perform();
		Thread.sleep(2000);
//			campaign.click();
		driver.executeScript("arguments[0].click();", campaign);

//			driver.findElement(By.xpath("//div//a[@title='Campaigns']//span']")).click();
		Thread.sleep(2000);
//			driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.linkText("Bootcamp")).click();
		Thread.sleep(5000);
		WebElement viewAll = driver.findElement(By.xpath("(//div//span[text()='View All'])[4]"));
		action.moveToElement(viewAll).perform();
		Thread.sleep(5000);
		WebElement addLead = driver.findElement(By.xpath("//a//div[@title='Add Leads']"));
		Thread.sleep(5000);
		action.moveToElement(addLead).perform();
		addLead.click();
		Thread.sleep(2000);
		WebElement searchLead = driver.findElement(By.xpath("//input[@title=\"Search Leads\"]"));
		searchLead.sendKeys(Keys.ENTER);

		WebElement search = driver
				.findElement(By.xpath("(//lightning-icon[@icon-name='utility:search']//span[@part='boundary'])[2]"));
		action.moveToElement(search).perform();
		search.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//span[@title='New Lead']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'salutation')]//a[@role='combobox']")).click();
		driver.findElement(By.xpath("//a[@title=\"Mr.\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Gokulakrishnan");
		driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("M");
		driver.findElement(By.xpath("(//label//span[text()='Company']//parent::label//following::input)[1]"))
				.sendKeys("TestLeaf");
		driver.findElement(By.xpath("//button[@title=\"Save\"]//span[text()='Save']")).click();
		Thread.sleep(1000);
		String text = driver
				.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']//..//span[contains(text(),'Lead')]"))
				.getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		String text1 = driver
				.findElement(By.xpath(
						"(//div[@data-aura-class='forceToastMessage']//..//div[contains(text(),'Bootcamp')])[1]"))
				.getText();
		System.out.println(text1);

		Thread.sleep(5000);
		WebElement lead = driver.findElement(By.xpath("//a//span[text()='Leads']"));
		action.moveToElement(lead).perform();
		Thread.sleep(2000);
//			campaign.click();
		driver.executeScript("arguments[0].click();", lead);
		Thread.sleep(2000);
		WebElement input = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
		input.sendKeys("Gokulakrishnan M");
		input.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span//a[@title=\"Gokulakrishnan M\"])[1]")).click();

		Thread.sleep(2000);
		String status = driver
				.findElement(By.xpath("//div//span[@title='Campaign History']//following::div//a[text()='Bootcamp']"))
				.getText();
		System.out.println(status);

		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(status, "Bootcamp", "Employee nod added to campaign");
		sAssert.assertAll();

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
