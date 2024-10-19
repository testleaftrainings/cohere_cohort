package week1.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_001_CreateAccount {

	@Test
	public void createAccount ()  {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.get("https://login.salesforce.com/");


		//Step 1: Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();		


		//	Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();


		//	Click view All and click Sales from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();


		//	Click on Accounts tab 
		WebElement elementAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", elementAccounts);


		//	Click on New button

		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//	Enter 'your name' as account name

		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Rajesh");
		
		
		//	Select Ownership as Public            
		WebElement dropDown =  driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
		driver.executeScript("arguments[0].click();", dropDown);
		
		WebElement publicEle = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@title='Public']"))));
		publicEle.click();
		
		
		//	Click save and verify Account name 

		driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		

		//	Account should be created Successfully
		WebElement toast = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))));
		String text = toast.getText();
		System.out.println(text);

	}
}
