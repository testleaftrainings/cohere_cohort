package sprint6_Devi;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class s6_14_Create_Opportunity {
	@Test
	public void createOpportunity() {
	ChromeDriver driver = new ChromeDriver();
	//Step 1: Launch the salesforce app
	driver.get("https://login.salesforce.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	//Step 2: Login with the credentials
	driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Leaf$321");
	
	//Step 3: Click Login
	driver.findElement(By.id("Login")).click();
	
	//Step 4: Click on the App Laucher Icon left to Setup
	driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

	//Click view All and click Sales from App Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	//Step 5: Click on Opportunities tab 
		// driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		
		//Step 5:	Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//Step 5:	6. Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and Store it 
		WebElement eleOpportunityName = driver.findElement(By.xpath("//label[text()='Opportunity Name']//following::input[1]"));
		eleOpportunityName.sendKeys("Salesforce Automation by Devipriya");
	    String OpportunityName = eleOpportunityName.getText();
	    
		//Step 5:	7. Choose close date as Today
	    WebElement eleCloseDate = driver.findElement(By.xpath("//label[text()='Close Date']//following::input[1]"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String closeDate= dateFormat.format(date);
		eleCloseDate.sendKeys(closeDate);
		
		//Step 5:8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//label[text()='Stage']//following::button[1]")).click();
		WebElement eleGroupType = driver.findElement(By.xpath("//label[text()='Stage']//following::button[1]//following::span[text()='Needs Analysis']"));
		eleGroupType.click();
		
		//Step 5:9. click Save and VerifyOppurtunity Name.  Expected Result:New Opportunity should be created with name as  'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		String Name= driver.findElement(By.xpath("(//span[text()='Opportunity Name']//following::lightning-formatted-text[contains(text(),'Salesforce Automation')])[2]")).getText();
		Name.equals(OpportunityName);
	}
}
