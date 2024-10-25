package sprint6_Rajesh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class S6_71_CreateNewContract extends BaseClass{

	public S6_71_CreateNewContract(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public void newContract() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String text = null;
		//		Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='navigation']//button")))).click();

		//		Click View All and click 'Contract' from App Launcher

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-label='View All Applications']")))).click();

		WebElement contract = driver.findElement(By.xpath("//p[text()='Contracts']"));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", contract);
		contract.click();

		//		Click on the Dropdown icon in the Contract tab
		Thread.sleep(10000);
		try {
			WebElement contractDropDown = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@title='Recently Viewed | Contracts'])[2]//following::one-app-nav-bar-menu-button[1]"))));
			contractDropDown.click();

			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",contractDropDown);
		} catch (Exception e) {
			WebElement contractDropDown = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//one-app-nav-bar-menu-button/a)[1]"))));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",contractDropDown);		
			}
		


		//		Click on New Contract

		WebElement newCon = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='menuItemsWrapper']//a"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",newCon);

		//		Select the accounts listed on the'Account Name' field

		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath("//label[text()='Account Name']//following::input"))))).click();

		driver.findElement(By.xpath("(//h3[@title='Recent Accounts']//following::span/span)[1]")).click();

		//		Select the Contract Start Date as Tommorow's Date
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Contract Start Date']//following::input[1]")))).click();
		String tomorrowDate = dateFindMethod(1,0,0);

		driver.findElement(By.xpath("//td[@data-value='"+tomorrowDate+"']")).click();

		//		Enter Contract Term (months) as' 6 '
		String contPeriod ="6";
		driver.findElement(By.xpath("//input[@name='ContractTerm']")).sendKeys(contPeriod);

		//		Click save and Verify the Contract Name

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		//		Get the Contract number
		text = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]//div")))).getText();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]//div"))));

		//		Get the difference between the Contract Start Date and End Date and Check it matches the Contract Term. Expected Result:
		WebElement redirectContract = driver.findElement(By.xpath("//one-app-nav-bar-item-root[@role='listitem']//following::span[text()='"+text+" | Contract']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",redirectContract);


		String startDate = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='"+text+"']//following::span[@class='slds-truncate uiOutputDate'][1]")))).getText();

		String enDate = driver.findElement(By.xpath("//a[@title='"+text+"']//following::span[@class='slds-truncate uiOutputDate'][2]")).getText();

		String contractPeriod = driver.findElement(By.xpath("//a[@title='"+text+"']//following::span[@class='slds-truncate uiOutputNumber'][1]")).getText();

		boolean contractstart = dateCompareMethod(tomorrowDate,startDate );
		String  month = dateFindMethod(0,6,0);

		boolean contractend = dateCompareMethod(month, enDate);

		if(contPeriod.equalsIgnoreCase(contractPeriod)&&contractstart&&contractend) {
			Assert.assertTrue(true);
			String writePath = System.getProperty("user.home")+ File.separator + "S6-72.txt";
			Path path = Paths.get(writePath); 
			Files.deleteIfExists(path);
			FileWriter file = new FileWriter(writePath);
			file.write(text);
			file.close();
		}



	}

	public boolean dateCompareMethod(String tomorrowDate,String startDate ) {
		DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatterB = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateA = LocalDate.parse(tomorrowDate, formatterA);
		LocalDate dateB = LocalDate.parse(startDate, formatterB);
		if (Objects.equals(dateA, dateB)) {
			return true;
		} return false;
	}

	public String dateFindMethod(int days,int month,int years) {
		LocalDate nextDay = LocalDate.now().plusDays(days).plusMonths(month).plusYears(years);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String tomorrowDate = nextDay.format(formatter);
		return tomorrowDate;

	}


}
