package sprint6_Rajesh;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NBATest extends BaseClass {

	public NBATest(RemoteWebDriver driver) {
		this.driver = driver;
	}
	public void verifyExp() {
		driver.get("https://www.nba.com/stats");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//		Click on 'See All Player Stats'
		try {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("onetrust-accept-btn-handler")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='See All Player Stats']")))).click();


		//		Choose 'Season' as '2023-24'
		adsMethod(driver, wait);

		WebElement season = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='nba-stats-primary-split-block']//label/div)[1]//select"))));

		new Select(season).selectByValue("2023-24");


		//		Choose 'Season Type' as 'NBA Cup'

		WebElement seasonType = driver.findElement(By.xpath("(//div[@class='nba-stats-primary-split-block']//label/div)[2]//Select"));

		new Select(seasonType).selectByValue("IST");




		//		Choose 'Per Mode' as 'Per Game'

		WebElement perMode = driver.findElement(By.xpath("(//div[@class='nba-stats-primary-split-block']//label/div)[3]//Select"));

		new Select(perMode).selectByValue("PerGame");


		//		Choose 'Season Segment' as 'Last Game'
		WebElement seasonSegment = driver.findElement(By.xpath("(//div[@class='nba-stats-primary-split-block']//label/div)[4]//Select"));

		new Select(seasonSegment).selectByVisibleText("Last Game");


		//		Click on the player name with lowest age

		List<WebElement> playerAgeEle = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='Crom_table__p1iZz']//following::tr//td[4]")));
		List<Integer> playerAge = getAllText(playerAgeEle);

		Integer min = Collections.min(playerAge);
		int poistion = playerAge.indexOf(min);

		//		Click on the Profile

		WebElement profile = driver.findElement(By.xpath("(//table[@class='Crom_table__p1iZz']//following::tr//td[2])["+poistion+"]"));

		wait.until(ExpectedConditions.elementToBeClickable(profile)).click();


		//		Get the Experience of the player

		String plaExp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//p[text()='EXPERIENCE']//following::p)[1]")))).getText();


		//		Verify the player experience as 1.
		Assert.assertTrue(plaExp.equalsIgnoreCase("1 Year"));

	}
	public  List<Integer> getAllText(List<WebElement> rawNameListEle) {

		List<Integer> namesList = new ArrayList<Integer>();
		for (WebElement element : rawNameListEle) {
			String text = element.getText();
			namesList.add(Integer.parseInt(text));  
		}
		return namesList;
	}
	private boolean adsMethod(RemoteWebDriver driver,WebDriverWait wait) {



		try {
			WebElement ad = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//form[@id='bx-form-2752274-step-1']")
					));
			boolean displayed = ad.isDisplayed();
			if (displayed) {
				WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='bx-wrap']//button)[3]")
						));
				closeButton.click();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return true;
		}



		try {
			WebElement ad2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
									By.xpath("//div[text()='Enter your email to create an NBA ID']//following::button[1]")
					));
			boolean displayed1 = ad2.isDisplayed();

			if (displayed1) {
				WebElement closeButton1 = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[text()='Enter your email to create an NBA ID']//following::button[1]")
						));
				closeButton1.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return true;
		}
		
		return true;





	}



}
