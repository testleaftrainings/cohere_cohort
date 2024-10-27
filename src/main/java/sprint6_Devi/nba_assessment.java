package sprint6_Devi;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.api.common.Value;

public class nba_assessment {
	@Test
	public void assessment() throws MalformedURLException {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		edgeOptions.setPlatformName("LINUX");
		DesiredCapabilities edgeDC = new DesiredCapabilities();
		edgeDC.setBrowserName("MicrosoftEdge");
		edgeDC.setPlatform(Platform.LINUX);
		edgeDC.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), edgeDC);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Assessment
		//----------
		//Test steps:
		// Step 1. Navigate to https://www.nba.com/stats
		
		driver.get("https:www.nba.com/stats");

		
		// Step 2. Click on 'See All Player Stats'
		
		WebElement cookies = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Continue without Deciding']")));
		
		try{
			cookies.click();
		}catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",cookies);
		}
		
        WebElement seeAllPlayerStats = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='See All Player Stats']")));
		
		try{
			seeAllPlayerStats.click();
		}catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",seeAllPlayerStats);
		}

		
		// Step 3. Choose 'Season' as '2023-24'
		
		WebElement season = driver.findElement(By.xpath("//p[text()='Season']/following::div[1]/select"));
		
		Select seasonOptions = new Select(season);
		seasonOptions.selectByVisibleText("2023-24");
		
		// Step 4. Choose 'Season Type' as 'NBA Cup'
		
        WebElement seasonType = driver.findElement(By.xpath("//p[text()='Season Type']/following::div[1]/select"));
		
		Select seasonTypeOptions = new Select(seasonType);
		seasonTypeOptions.selectByVisibleText("NBA Cup");
		
		// Step 5. Choose 'Per Mode' as 'Per Game'
		
        WebElement perMode = driver.findElement(By.xpath("//p[text()='Per Mode']/following::div[1]/select"));
		
		Select perModeOptions = new Select(perMode);
		perModeOptions.selectByVisibleText("Per Game");
		
		// Step 6. Choose 'Season Segment' as 'Last Game'
		
        WebElement seasonSegment = driver.findElement(By.xpath("//p[text()='Season Segment']/following::div[1]/select"));
		
		Select seasonSegmentOptions = new Select(seasonSegment);
		seasonSegmentOptions.selectByVisibleText("Last Game");
		
		// Step 7. Click on the player name with lowest age
		
	
		 int minAge = Integer.MAX_VALUE;
	        int noOfRows = driver.findElements(By.xpath("//th[text()='Age']/following::tbody/tr/td[4]")).size();
	        System.out.println("Number of rows found: " + noOfRows);
	        int rowIndexOfLowestAge = -1;

	        for (int i = 1; i <= noOfRows; i++) {
	           String ageText = driver.findElement(By.xpath("//th[text()='Age']/following::tbody/tr[" + i + "]/td[4]")).getText();
	            int age = Integer.parseInt(ageText);
	            System.out.println("Row " + i + ": Parsed age = " + age);

	           if (age < minAge) {
	                minAge = age;
	                rowIndexOfLowestAge = i;
	            }
	           System.out.println("Row index with lowest age: " + rowIndexOfLowestAge);
	        }
	        System.out.println("Row index with lowest age: " + rowIndexOfLowestAge);
		// use this i in next step
		
		// Step 8. Click on the Profile
		
		 driver.findElement(By.xpath("//th[text()='Age']//following::tbody//tr["+ rowIndexOfLowestAge +"]//td[2]")).getText();
		
		// Step 9. Get the Experience of the player
		 
		 String experience = driver.findElement(By.xpath("(//p[text()='EXPERIENCE'])[1]/following::p")).getText();
			
		
		// Step 10. Verify the player experience as 1.

		 Assert.assertEquals(experience, "1");
		 
		
	}
	


}
