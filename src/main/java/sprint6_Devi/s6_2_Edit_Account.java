package sprint6_Devi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class s6_2_Edit_Account {
@Test
public void editAccount() {
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

	//Step 5: Click on Accounts tab 
	// driver.findElement(By.xpath("//a[@title='Accounts']")).click();
	WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
	driver.executeScript("arguments[0].click();", eleAccounts);
	
	//Step 6: Search for the Account Using the unique account name created by you 
	driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Devipriya");
	driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.ENTER);
	
	//Step 7:  Click on the displayed Account Dropdown icon and select Edit
	try {
	driver.findElement(By.xpath("//a[@title='Devipriya']")).click();
	}
	catch(StaleElementReferenceException e) {
		driver.findElement(By.xpath("//a[@title='Devipriya']")).click();
	}
	
	//Step 8: Select Type as Technology Partner
	driver.findElement(By.xpath("//a[@data-tab-value='detailTab']")).click();
	driver.findElement(By.xpath("(//span[text()='Type']//following::button//span[1])[1]")).click();
	WebElement eleType =driver.findElement(By.xpath("//label[text()='Type']//following::button[1]"));
	//driver.executeScript("arguments[0].scrollIntoView();", eleType);
	Actions actions = new Actions(driver);
	actions.moveToElement(eleType);
	actions.perform();
	driver.executeScript("arguments[0].click();", eleType);
	driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
	
	//Step 9: Select Industry as Healthcare 
	driver.findElement(By.xpath("//label[text()='Industry']//following::button[1]")).click();
	driver.findElement(By.xpath("//div//lightning-base-combobox-item[@data-value='Healthcare']")).click();
	
	//Step 10: Enter Billing Address
	driver.findElement(By.xpath("//label[text()='Billing Street']//following::div[1]//textarea[@name='street']")).sendKeys("street");
	driver.findElement(By.xpath("//label[text()='Billing City']//following::div[1]//input[@name='city']")).sendKeys("city");
	driver.findElement(By.xpath("//label[text()='Billing Zip/Postal Code']//following::div[1]//input[@name='postalCode']")).sendKeys("600096");
	driver.findElement(By.xpath("//label[text()='Billing State/Province']//following::div[1]//input[@name='province']")).sendKeys("province");
	driver.findElement(By.xpath("//label[text()='Billing Country']//following::div[1]//input[@name='country']")).sendKeys("country");
	
	//Step 11: Enter Shipping Address
	driver.findElement(By.xpath("//label[text()='Shipping Street']//following::div[1]//textarea[@name='street']")).sendKeys("Shiva Street");
	driver.findElement(By.xpath("//label[text()='Shipping City']//following::div[1]//input[@name='city']")).sendKeys("Chennai");
	driver.findElement(By.xpath("//label[text()='Shipping Zip/Postal Code']//following::div[1]//input[@name='postalCode']")).sendKeys("600054");
	driver.findElement(By.xpath("//label[text()='Shipping State/Province']//following::div[1]//input[@name='province']")).sendKeys("Thiru");
	driver.findElement(By.xpath("//label[text()='Shipping Country']//following::div[1]//input[@name='country']")).sendKeys("India");
	
	//Step 12:Select Customer Priority as Low
	WebElement eleCusPriority =driver.findElement(By.xpath("//label[text()='Customer Priority']//following::button[1]"));
	actions.moveToElement(eleCusPriority);
	actions.perform();
	driver.executeScript("arguments[0].click();", eleCusPriority);
	driver.findElement(By.xpath("//label[text()='Customer Priority']//following::button[1]//following::span[text()='Low']")).click();
	//driver.findElement(By.xpath("//label[text()='Active']//following::button[1]//following::span[text()='No']")).click();
	
	//Step 13:Select SLA as Silver
	WebElement eleSLA =driver.findElement(By.xpath("//label[text()='SLA']//following::button[1]"));
	actions.moveToElement(eleSLA);
	actions.perform();
	driver.executeScript("arguments[0].click();", eleSLA);
	driver.findElement(By.xpath("//label[text()='SLA']//following::button[1]//following::span[text()='Silver']")).click();
	
	//Step 14:Select Active as NO 
	WebElement eleActive= driver.findElement(By.xpath("//label[text()='Active']//following::button[1]"));
	actions.moveToElement(eleActive);
	actions.perform();
	driver.executeScript("arguments[0].click();", eleActive);
	driver.findElement(By.xpath("//label[text()='Active']//following::button[1]//following::span[text()='No']")).click();
	
	//Step 15:Enter Unique Number in Phone Field
	driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("12345678");
	
	//Step 16:Select Upsell Oppurtunity as No
	WebElement eleUpsell= driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//following::button[1]"));
	actions.moveToElement(eleUpsell);
	actions.perform();
	driver.executeScript("arguments[0].click();", eleUpsell);
	driver.findElement(By.xpath("(//label[text()='Upsell Opportunity']//following::button[1]//following::span[text()='No'])[1]")).click();
	
	//Step 17:Click on save and verfiy Phone number
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	String PhoneNumber= driver.findElement(By.xpath("(//span[text()='Phone']//following::dd//a)[2]")).getText();
	PhoneNumber.equals("12345678");
	
}
}
