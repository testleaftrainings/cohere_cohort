package sprint6_Rajesh;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class S6_90_Verify_Newly_Created extends BaseClass{
	public S6_90_Verify_Newly_Created(RemoteWebDriver driver) {
		this.driver=driver;
	}


	public void Newly_Created() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equalsIgnoreCase("https://testleaf-7b-dev-ed.develop.lightning.force.com/lightning/setup/SetupOneHome/home")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")))).click();
		}
		//home button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("home_Tab")))).click();
		//		Click on the 'File'
		Thread.sleep(2000);
		WebElement file = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@id='publisherAttachContentPost']//following::span)[1]"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", file);

		//		Click on 'Select a file from Salesforce'

		driver.findElement(By.id("chatterLinkFileAction")).click();

		//		Click on 'Owned by Me'
		windowHandle(driver, 1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Owned by Me']"))).click();


		//		Search for 'Maven'

		driver.findElement(By.xpath("(//div[@class='zen-facet zen-facetnavigation']//following::input)[1]")).sendKeys("Maven");
		driver.findElement(By.xpath("//a[@title='Search']")).click();

		//		Click on the 'Attach' for Maven file
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//td[@class='attach zen-first-child']/a")))).click();


		//		Click on the 'Share' Button
		windowHandle(driver, 0);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='publishersharebutton']")))).click();

		//		Click on the 'More Actions'
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@title='Open More Actions list'])[1]")))).click();

		//		Click on the 'File Sharing Settings'

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[text()='File Sharing Settings'])[1]")))).click();



		//		Change permissions as 'Collaborators'

		WebElement permissions = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class='permissionLabel'])[1]"))));
		String permission = permissions.getText();
		if (!permission.equalsIgnoreCase("Collaborators")) {
			permissions.click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Collaborators']")))).click();
		}

		//		Enable the checkBox for 'Prevent others from sharing and unsharing'
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='sharingOption']"));
		if (!checkbox.isEnabled()) {
			checkbox.click();
		}


		//		Verify the checkbox is Enabled
		Assert.assertTrue(checkbox.isEnabled());

		//		Click on the 'Close' button.
		driver.findElement(By.xpath("//div[@class='buttonBar zen']/input")).click();

		//		Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.

		Faker fake = new Faker();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("((//span[@class='feeditemActionMenu'])[1]//a)[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@title='Add topics to this post'])[1]")))).click();
		String dish = fake.food().dish();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='topicInput']//textarea")))).sendKeys(dish);
		driver.findElement(By.xpath("//input[@title='Done']")).click();

		//		Verify the Topics as 'Maven Installtion Guide'
		Thread.sleep(2000);
		String verify = driver.findElement(By.xpath("(//div[@class='view accessible']//a)[2]")).getText();

		Assert.assertTrue(dish.equalsIgnoreCase(verify));


		//		Click on the widget dropdown for post and click 'Delete'

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("((//span[@class='feeditemActionMenu'])[1]//a)[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@title='Delete this post'])[1]")))).click();



		//		Click on the 'Ok' Button.
		Thread.sleep(2000);
		try {
			windowHandle(driver, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			windowHandle(driver, 1);
		}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@class='buttons'])//input[1]")))).click();

		//		Verify the post is Deleted.
		Thread.sleep(2000);
		try {
			windowHandle(driver, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			windowHandle(driver, 0);
		}
		boolean element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='feeditembody']")))).isDisplayed();
		if (element) {
			List<WebElement> deleteVerify = null;
			try {
				deleteVerify = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='view accessible']//a)[2]")));
				List<String> allText = getAllText(deleteVerify);
				Assert.assertFalse(allText.contains(dish));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Assert.assertTrue(true);
			}
		}

	}

	public void windowHandle(RemoteWebDriver driver,int a) {

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowList.get(a));


	}
	public  List<String> getAllText(List<WebElement> rawNameListEle) {

		List<String> namesList = new ArrayList<String>();
		for (WebElement element : rawNameListEle) {
			namesList.add(element.getText());  // Get text and add to namesList
		}
		return namesList;
	}
}
