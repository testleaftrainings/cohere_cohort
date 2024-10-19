package selenium_grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Practise_Sel_Grid_Classroom {
	@Test
	public void verifyLegalEntities() throws ParseException, InterruptedException, MalformedURLException {
	DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("MicrosoftEdge");
			dc.setPlatform(Platform.LINUX);
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
					
					//ChromeDriver driver = new ChromeDriver();
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

					//Step 3. Click View All and click Legal Entities from App Launcher
					driver.findElement(By.xpath("//button[text()='View All']")).click();
					WebElement eleLegalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
					driver.executeScript("arguments[0].click();", eleLegalEntities);
					
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
}
}
