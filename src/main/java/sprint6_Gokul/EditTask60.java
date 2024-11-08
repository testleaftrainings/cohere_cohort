package sprint6_Gokul;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EditTask60 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void editTaskMethod() throws Exception {

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
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//header//span[@title=\"Today’s Tasks\"]//following::div//span[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Recently Viewed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li//a//span[text()='Recently Viewed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Email");
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div//span[text()='Email']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"uiPopupTrigger\"]//a[@title=\"Show 6 more actions\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li//a[@title='Edit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label//span[text()='Related To']//following::div//a//span[@class=\"deleteIcon\"])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label//span[text()='Related To']//following::div//a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li//a[@title='Accounts']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label//span[text()='Related To']//following::div//input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Gokul']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title=\"Save\"]")).click();
		

}
}