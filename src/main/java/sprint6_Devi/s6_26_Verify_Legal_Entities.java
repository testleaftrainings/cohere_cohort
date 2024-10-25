package sprint6_Devi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import sprint6_Rajesh.RetryEvent;

public class s6_26_Verify_Legal_Entities {
	@Test(retryAnalyzer = RetryEvent.class)
	public void verifyLegalEntities() throws ParseException, InterruptedException {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(edgeOptions);
		//Step 1: Launch the salesforce app
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Step : Login with the credentials
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");

		//Step : Click Login
		driver.findElement(By.id("Login")).click();

		//Step 2: Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Step 3. Click View All and click Legal Entities from App Launcher
		try {
			driver.findElement(By.xpath("//button[text()='View All']")).click();
		} catch (Exception e) {
			driver.navigate().refresh();
		}
		try {
			WebElement eleLegalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
			driver.executeScript("arguments[0].click();", eleLegalEntities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.navigate().refresh();
			Thread.sleep(2000);
			WebElement eleLegalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		}

		//Step 4. Click on the legal Entities tab 
		//driver.findElement(By.xpath("//span[text()='Legal Entities']")).click();
		WebElement eleLegalEntities1 = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", eleLegalEntities1);

		//Step 5. Click the sort arrow in the Last Modified Date.
		//driver.findElement(By.xpath("//span[text()='Last Modified Date']")).click();
		Thread.sleep(5000);
		WebElement eleLastModifiedDate = driver.findElement(By.xpath("(//thead//a)[2]"));
		driver.executeScript("arguments[0].click();", eleLastModifiedDate);
		Thread.sleep(5000);
		driver.executeScript("arguments[0].click();", eleLastModifiedDate);

		//Step 6. Verify the Legal Entities displayed in ascending order by Last Modified Date.
		Thread.sleep(2000);
		String LastModifiedDate = driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).getText();
		System.out.println(LastModifiedDate.equals("Sorted Ascending"));
		List<WebElement> dateElements = driver.findElements(By.xpath("//tbody//td[3]/span/span[1]")); 						 	 
		List<Date> dates = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, hh:mm a");

		for (WebElement dateElement : dateElements) {
			String dateText = dateElement.getText();
			Date parsedDate = dateFormat.parse(dateText);
			dates.add(parsedDate);
		}

		List<Date> sortedDates = new ArrayList<>(dates);
		Collections.sort(sortedDates);

		if (dates.equals(sortedDates)) {
			System.out.println("The dates are in ascending order.");
		} else {
			System.out.println("The dates are NOT in ascending order.");
		}
		//Step Expected Result: Legal Entities Should be displayed in ascending order by Last Modified Date.     
		driver.quit();
	}
}