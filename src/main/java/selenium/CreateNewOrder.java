package Selenium;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateNewOrder {
@Test
public void createNewOrder() {
	ChromeDriver driver = new ChromeDriver();
	//Step 1: Launch the salesforce app
	driver.get("https://login.salesforce.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Step : Login with the credentials
	driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Leaf$321");
	
	//Step : Click Login
	driver.findElement(By.id("Login")).click();
	
	//Step 2: Click on the App Laucher Icon left to Setup
	driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

	//Step 3: Click view All and click Service Control from App Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	WebElement eleServiceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
	driver.executeScript("arguments[0].click();", eleServiceConsole);
	
	//Step :4. Click on the drop down and select Orders 
	driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
	WebElement eleOrders = driver.findElement(By.xpath("//span[text()='Orders']"));
	driver.executeScript("arguments[0].click();", eleOrders);
	
	//Step :5. Click on New 
	String orderNumber= driver.findElement(By.xpath("(//tbody//a)[1]")).getText();
	driver.findElement(By.xpath("//div[@title='New']")).click();
	
	//Step :6. Select Account name as Testleaf Software 
	driver.findElement(By.xpath("//label[text()='Account Name']//following::input[1]")).click();
	driver.findElement(By.xpath("//li//following::span[text()='Testleaf Software']")).click();
	
	//Step :7. Contract number as '00000103' 
	driver.findElement(By.xpath("//label[text()='Contract Number']//following::input[1]")).click();
	driver.findElement(By.xpath("//li//following::span[text()='00000130']")).click();

	//Step :8. Status as Draft 
	driver.findElement(By.xpath("//label[text()='Status']//following::button[1]")).click();
	driver.findElement(By.xpath("//div[@aria-label='Status']//span[text()='Draft']")).click();

	//Step :9.Select Order Start Date as next month 10th date 
	 WebElement eleOrderStartDate = driver.findElement(By.xpath("//label[text()='Order Start Date']//following::input[1]"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String startDate= dateFormat.format(date);
		eleOrderStartDate.sendKeys(startDate);
	//Step :10. Click Save            
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String currentOrder= driver.findElement(By.xpath("//img[@title=('Order')]//following::lightning-formatted-text[1]")).getText();
		if(Integer.parseInt(currentOrder)==(Integer.parseInt(orderNumber)+1)) {
			System.out.println("Successfully Order number was created.");  
		}
	//Step :Expected Result: success Order number was created.                    
}
}
	