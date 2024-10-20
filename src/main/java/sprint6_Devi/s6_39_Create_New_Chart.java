package sprint6_Devi;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class s6_39_Create_New_Chart {
@Test
public void createNewChart() {
	ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
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

		
		//Step :5.Click on drop down near Recently viewed and change into 'All'. 
		driver.findElement(By.xpath("(//span[text()='Recently Viewed']//following::button[1])[1]")).click();
		driver.findElement(By.xpath("//span[text()='All Refunds']")).click();
		
		//Step :6. Click on Chart icon under New Button 
		driver.findElement(By.xpath("//button[@title='Charts']")).click();
		
		//Step :7. Click New Chart 
		driver.findElement(By.xpath("//a[@title='Settings']")).click();
		driver.findElement(By.xpath("//a[@title='New Chart']")).click();
		
		//Step :8. Give Chart Name and Select Chart Type 
		driver.findElement(By.xpath("//label[text()='Chart Name']/following::input")).sendKeys("Devipriya");
		driver.findElement(By.xpath("//label[text()='Chart Type']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[text()='Vertical Bar Chart']")).click();
		
		//Step :9. Select Aggregate Type as Average and ggregate Field as Amount 
		driver.findElement(By.xpath("//label[text()='Aggregate Type']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[text()='Average']")).click();
	
		//Step :10. Select Grouping Field as Account and click Save 
		//driver.findElement(By.xpath("//label[text()='Grouping Field']/following::button[1]")).click();
		WebElement eleGroupingField = driver.findElement(By.xpath("//label[text()='Grouping Field']/following::button[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(eleGroupingField);
		actions.perform();
		driver.executeScript("arguments[0].click();", eleGroupingField);
		
		driver.findElement(By.xpath("//div[@aria-label='Grouping Field']//span[text()='Account']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		//Step :11. Click on settings icon and change the Chart Type 
		WebElement chart=driver.findElement(By.xpath("//div[@class='eclairChartWrapper vbar']"));
		if (chart.isDisplayed()) {
             System.out.println("vbar Chart is present and displayed.");
         } else {
             System.out.println("vbar Chart is present but not visible.");
         }
		
		WebElement eleSettings = driver.findElement(By.xpath("//a[@title='Settings']"));
		actions.moveToElement(eleSettings);
		actions.perform();
		driver.executeScript("arguments[0].click();", eleSettings);
		driver.findElement(By.xpath("//a[text()='Donut Chart']")).click();
		
		//Step :Expected Result: The Chart type should be changed.  
		WebElement chart1=driver.findElement(By.xpath("//div[@class='eclairChartWrapper pie']"));
		if (chart1.isDisplayed()) {
             System.out.println("pie Chart is present and displayed.");
         } else {
             System.out.println("pie Chart is present but not visible.");
         }
		
}
}
