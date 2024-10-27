package sprint6_Rajesh;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class S6_89_SalesForce_Classic_NewAccount extends BaseClass{
	public S6_89_SalesForce_Classic_NewAccount(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public void classic_NewAccount() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//		Navigate to Salesforce login page

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equalsIgnoreCase("https://testleaf-7b-dev-ed.develop.lightning.force.com/lightning/setup/SetupOneHome/home")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']//button"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")))).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("home_Tab")))).click();



		//		Choose 'Account' from the dropdown
		WebElement accountDrop = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("createNewSelect")));
		Select select = new Select(accountDrop);
		select.selectByVisibleText("Account");

		//		Click on the 'Go!' button.
		driver.findElement(By.id("createNewGo")).click();
		Faker fake = new Faker();
		//		Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
		String firstName = fake.name().firstName();
		WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='requiredInput']//input")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", name);
		name.sendKeys("BootCamp Puppeteer"+firstName);
		//		Enter the Billing Address
		String streetName = fake.address().streetName();
		String cityName = fake.address().cityName();
		String zipCode = fake.address().zipCode();
		String state = fake.address().state();
		String country = fake.address().country();
		List<String> input = new ArrayList<>();
		input.add(streetName);
		input.add(cityName);
		input.add(zipCode);
		input.add(state);
		input.add(country);

		// Get the textarea element by its ID
		driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::textarea)[1]")).sendKeys(streetName);
		driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[1]")).sendKeys(cityName);
		driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[3]")).sendKeys(zipCode);
		driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[5]")).sendKeys(state);
		driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[7]")).sendKeys(country);

		//		Click Copy Billing Address to Shipping Address link

		driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();

		//		Verify the Shipping Address reflects the Billing Address

		String text = driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::textarea)[2]")).getAttribute("value");
		String text2 = driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[2]")).getAttribute("value");
		String text3 = driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[4]")).getAttribute("value");
		String text4 = driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[6]")).getAttribute("value");
		String text5 = driver.findElement(By.xpath("((//table[@class='detailList'])[2]//following::input)[8]")).getAttribute("value");

		List<String> output = new ArrayList<>();
		output.add(text);
		output.add(text2);
		output.add(text3);
		output.add(text4);
		output.add(text5);
		Collections.sort(input);
		Collections.sort(output);
		boolean areEqual = input.equals(output);
		Assert.assertTrue(areEqual);

		//		Enter the SLA Expiration Date as Current Date + 20 days

		WebElement sLA = driver.findElement(By.xpath("(((//table[@class='detailList'])[3])//following::input)[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",sLA);
		sLA.click();
		String date = date();
		//	27/November/2024
		String[] split = date.split("/");
		WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.id("calMonthPicker")));
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", month);
		Select select1 = new Select(month);

		
		select1.selectByVisibleText(split[1].toString());
		
		WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.id("calYearPicker")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", year);

		Select select2 = new Select(year);
		select2.selectByVisibleText(split[2].toString());

		String day = split[0].toString();

		WebElement day1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='"+day+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", day1);


		//		Click on Save button.
		WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",save);
		save.click();


		//		Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
	
		List<WebElement> recentList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='mruList individualPalette']//span")));

		List<String> allText = getAllText(recentList);

		boolean contains = allText.contains("BootCamp Puppeteer"+firstName);
		Assert.assertTrue(areEqual);

		//		Navigate to Accounts tab and Verify the newly Created account is displayed

		driver.findElement(By.id("Account_Tab")).click();
		
		List<WebElement> mainAccount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='list']//following::a")));
		List<String> myCreation = getAllText(mainAccount);
		boolean contains1 = allText.contains("BootCamp Puppeteer"+firstName);
		Assert.assertTrue(contains1);


	}

	public  List<String> getAllText(List<WebElement> rawNameListEle) {

		List<String> namesList = new ArrayList<String>();
		for (WebElement element : rawNameListEle) {
			namesList.add(element.getText());  // Get text and add to namesList
		}
		return namesList;
	}

	public String date() {
		LocalDate newDate = LocalDate.now().plusDays(20);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");

		String Days = newDate.format(formatter);
		return Days;

	}
}
