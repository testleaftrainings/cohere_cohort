package Sprint6_Gokul;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class deleteAccount03 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void deleteAccMethod() throws InterruptedException {

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
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement acc = driver.findElement(By.xpath("//a//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", acc);

		Thread.sleep(5000);
//			WebElement accName =driver.findElement(By.xpath("//a[@title='Accounts']/span[text()='Accounts']"));
//			driver.executeScript("arguments[0].click();", accName);
//			Thread.sleep(5000);
		WebElement delAcc = driver.findElement(By.xpath("//input[@name='Account-search-input']"));
		delAcc.sendKeys("Gokulakrishnan");
		delAcc.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']//a[@role='button']"))
				.click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement del = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//a[@title='Delete']")));
		del.click();
		Thread.sleep(5000);
//			driver.findElement(By.xpath("//div[@role='menu']//li//div[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']/span[text()='Delete']")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
	}

	@AfterTest
	public void afMethod() {
		driver.quit();
	}

}
