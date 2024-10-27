package sprint6_Devi;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class s6_20_Edit_Contact {
	@Test
	public void editContact() {
		ChromeDriver driver = new ChromeDriver();
		//Step 1: Launch the salesforce app
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Step 2: Login with the credentials
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		
		//Step 3: Click Login
		driver.findElement(By.id("Login")).click();
		
		//Step 4: Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Step 5: Click view All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//Step 6) Click on contacts under 'All Items'
        WebElement eleWorkType = driver.findElement(By.xpath("//p[text()='Contacts']"));
		driver.executeScript("arguments[0].click();", eleWorkType);
		
		//Step 7) Get the size of conatcts available and print the list
		List<WebElement> eleTableRows = driver.findElements(By.xpath("//span[contains(text(),'Updated')]//following::tbody//tr"));
		int rowCount = eleTableRows.size();
		System.out.println("No of rows in this table : " + rowCount);
		for(WebElement row:eleTableRows){ 
			WebElement headerCell = row.findElement(By.tagName("th"));
            if (headerCell != null) {
                System.out.print(headerCell.getText() + "\t");
            }
			 List<WebElement> eleTableColumns = row.findElements(By.xpath(".//td"));
			 for (WebElement column : eleTableColumns) {
	                 System.out.print(column.getText() + "\t");
	            }

	            System.out.println(); 
	        }

		//Step 8) search for the contact using unique name 
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Devipriya Raja");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		
		//Step 9) Click on the dropdown icon available in the unique contact and select edit
		driver.findElement(By.xpath("//span[contains(text(),'Updated')]//following::tbody//tr[1]/td[8]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		//Step 10) Edit Title as Test
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("Test");
		
		//Step 11) select your birthday in the birthday field
		driver.findElement(By.xpath("//input[@name='Birthdate']")).sendKeys("29/02/1987");
		
		//Step 12) edit Lead Source as Purchased list
		driver.findElement(By.xpath("//label[text()='Lead Source']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[text()='Purchased List']")).click();
		
		//Step 13) Edit Phone number with personal number
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("9999999999");
		
		//Step 14) Click Save and Verify and Print Phone number
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//Step 8) search for the contact using unique name 
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Devipriya Raja");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		String phone = driver.findElement(By.xpath("//span[contains(text(),'Updated')]//following::tbody//tr[1]/td[5]")).getText();
		phone.equals("9999999999");
				
	}
}
