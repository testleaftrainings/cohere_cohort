package selenium;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateNewRefund {
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
	
	//Step :4. Click on the drop down and select Refunds 
	driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
	WebElement eleRefunds = driver.findElement(By.xpath("//span[text()='Refunds']"));
	driver.executeScript("arguments[0].click();", eleRefunds);
	
	//Step :5. Click on New 
	driver.findElement(By.xpath("//div[text()='New']")).click();
	
	//Step :6. Select Account name 
	driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
	driver.findElement(By.xpath("//div[@title='Testleaf Software']")).click();
	
	//Step :7. Select Status as Canceled 
	driver.findElement(By.xpath("//h2[text()='New Refund']//following::span[text()='Status']//following::a[1]")).click();
	driver.findElement(By.xpath("(//h2[text()='New Refund']//following::span[text()='Status']//following::a[1]//following::li/a)[6]")).click();
	
	//Step :8. Give Amount as 50000 and select Referenced in Type 
	driver.findElement(By.xpath("//label/span[text()='Amount']/following::input[1]")).sendKeys("50000");
	driver.findElement(By.xpath("//span/span[text()='Type']/following::a[1]")).click();
	driver.findElement(By.xpath("(//span/span[text()='Type']/following::a[1]//following::li/a)[8]")).click();
	
	//Step :9. Select Processing Mode as External 
	driver.findElement(By.xpath("//span/span[text()='Processing Mode']/following::a[1]")).sendKeys("50000");
	driver.findElement(By.xpath("(//span/span[text()='Processing Mode']/following::a[1]//following::li/a)[12]")).click();
	
	//Step :10. Click Save   
	driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	
	//Step :Expected Result:success Refund 'R-000000001' was created.       
	String refundNumber= driver.findElement(By.xpath("//div[text()='Refund']//following::span[1]")).getText();
	System.out.println(refundNumber);
}
}
