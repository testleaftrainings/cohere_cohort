package sprint6_Gokul;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateFollowUpTask59 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void createFollowUpMethod() throws Exception {

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span//p[text()='Content']")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//header//span[@title=\"Today’s Tasks\"]//following::div//span[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title=\"Select list display\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@title=\"Display as table\"]//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@data-aura-class='forceVirtualAction'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//li//a[@title='Create Follow-Up Task'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='pillText']")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//label[text()='Subject']//following::div//input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//lightning-base-combobox-item[@data-value='Call']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div//span[text()='Priority'])[2]//following::div//a[@role=\"combobox\"]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li//a[text()='High']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div//span[text()='Status'])[2]//following::div//a[@role='combobox'])[1]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li//a[@title=\"In Progress\"]")).click();
		Thread.sleep(5000);
		try {

			driver.findElement(
					By.xpath("((//div//span[text()='Name'])[3]//following::div//a[@class=\"deleteAction\"]//span)[1]"))
					.click();
		} catch (Exception e) {
			System.out.println("Catch block");
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div//span[text()='Name'])[3]//following::div//span//img)[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//span[@title='Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title=\"Search Contacts\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div//span[text()='Name'])[3]//following::div//div//ul//li)[1]")).click();
		Thread.sleep(5000);
		try {

			driver.findElement(By.xpath(
					"((//div//span[text()='Related To'])[3]//following::div//a[@class=\"deleteAction\"]//span)[1]"))
					.click();
		} catch (Exception e) {
			System.out.println("Catch block");
		}
		driver.findElement(By.xpath("((//div//span[text()='Related To'])[3]//following::div//span//img)[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//span[@title='Accounts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title=\"Search Accounts\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//div//span[text()='Related To'])[3]//following::div//div//ul//li)[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title=\"Save\"]//span[text()='Save']")).click();
	}

//	@AfterMethod
//	public void close() {
//		driver.quit();
//	}
}
