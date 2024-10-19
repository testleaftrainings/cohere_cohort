package jiraSaleforceAssessment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import java.time.Duration;

public class CreateLeadForCampaign_S048 extends BaseClass {
	public CreateLeadForCampaign_S048(WebDriver driver) {
		this.driver =driver;
	}

	@Test
	public void salesForce() throws InterruptedException {


		// Click on toggle menu button from the left corner
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("return document.readyState").equals("complete");

		WebElement appLauncher = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='App Launcher']")));
		appLauncher.click();
		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//input[@role='combobox' and @placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("//one-app-launcher-app-tile[@data-name='Sales']//mark[text()='Sales']")).click();

		// Click on Campaigns tab

		js.executeScript("return document.readyState").equals("complete");

		WebElement camp = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//a[@title='Campaigns']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", camp);

		// Click Bootcamp link
		Thread.sleep(2000);
		WebElement bootCamp = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//a[text()='Bootcamp']"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bootCamp);


		// Click Add Leads

		try {
			WebElement eleAddLead = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Add Leads'][normalize-space()='Add Leads']")));
			js.executeScript("arguments[0].scrollIntoView(true);", eleAddLead);
			eleAddLead.click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			Thread.sleep(2000);
			WebElement eleAddLead = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Add Leads'][normalize-space()='Add Leads']")));
			js.executeScript("arguments[0].scrollIntoView(true);", eleAddLead);
			eleAddLead.click();
		}

		// Click on New Lead

		try {
			WebElement eleSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search Leads']")));
			eleSearch.click();
			Boolean state = wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@title='Search Leads']"), "aria-expanded", "true"));
			if (state) {
				eleSearch.sendKeys("new");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			WebElement eleSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search Leads']")));
			eleSearch.click();
			Boolean state = wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@title='Search Leads']"), "aria-expanded", "true"));
			if (state) {
				eleSearch.sendKeys("new");
			}
		}


		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@title='New Lead']")))).click();




		// Pick Salutation as 'Mr.'
		driver.findElement(By.xpath("(//span[text()='Salutation']/parent::span)/following-sibling::div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']//a[@role='combobox']")).click();


		driver.findElement(By.xpath("//a[@title='Mrs.']")).click();


		// Enter first name as <your First Name>


		Faker fake = new Faker();
		String userName = fake.name().username();

		WebElement eleFirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

		eleFirstName.click();
		eleFirstName.sendKeys(userName);


		// Enter last name as <your last name>
		String lastName = fake.name().lastName(); 

		WebElement eleLastName = driver.findElement(By.xpath("//span[text()='Last Name']/parent::label/following-sibling::input"));
		eleLastName.click();
		eleLastName.sendKeys(lastName);

		// Enter company as 'TestLeaf'
		String cmpyName = fake.company().name();


		WebElement eleCompany = driver.findElement(By.xpath("(//span[text()='Company']/parent::label)/following-sibling::input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eleCompany);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCompany);
		eleCompany.sendKeys(cmpyName);

		// Click Save
		driver.findElement(By.xpath("//button[@title='Cancel']/following-sibling::button[@title='Save']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))));

		// Click Next
		driver.findElement(By.xpath("//button[text()='Next']")).click();


		// Click Submit on the Add to Campaign pop up
		Thread.sleep(2000);
		WebElement eleSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSubmit);

		//	Bootcamp was successfully updated.
		WebElement toast = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toastTitle slds-text-heading--small']"))));
		String text = toast.getText();
		if (text.contains("Bootcamp was successfully updated.")) {
			WebElement leads = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//a[@title='Leads']"))));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", leads);
			Thread.sleep(2000);

			WebElement search = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
			search.sendKeys(userName);
			search.click();
			String verify= userName+" "+lastName;

			String output = driver.findElement(By.xpath("(//div[@title='New']//following::a)[14]")).getText();
			Assert.assertEquals(verify, output);
		}

	}

}
