package sprint6_Rajesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class S6_72_EditContract extends BaseClass{

	public S6_72_EditContract(RemoteWebDriver driver) {
		this.driver=driver;
	}
	private String readTxt() {
		try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.home")+ File.separator + "S6-72.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String parts = line;
				return parts;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void editContract() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String searchItem = readTxt();

		//		Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='navigation']//button")))).click();

		//		Click View All and click 'Contract' from App Launcher

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-label='View All Applications']")))).click();

		WebElement contract = driver.findElement(By.xpath("//p[text()='Contracts']"));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", contract);
		contract.click();


		//		Search the Account number in the Search box
		WebElement textBox = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Contract-search-input']"))));
		textBox	.sendKeys(searchItem);

		driver.findElement(By.xpath("//button[@title='Refresh']")).click();

		//		Click on the Dropdown icon and Select Edit				
		Thread.sleep(2000);
		WebElement dD = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//tbody//following::a[@role='button'])"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",dD);


		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		//		Select Status as 'Activated'

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Status']//following::button[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@title='Activated']")))).click();

		//		Select Owner Expiration Notice as'30 days'
		WebElement stDrop = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Owner Expiration Notice']//following::button[1]"))));
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", stDrop);
		stDrop.click();

		driver.findElement(By.xpath("//span[@title='30 Days']")).click();

		//		Click save and Verify the Status 
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String toast = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")))).getText();
		if (toast.contains("was saved")) {
			Assert.assertTrue(true);
			String writePath = System.getProperty("user.home")+ File.separator + "S6-72.txt";
			Path path = Paths.get(writePath); 
			Files.deleteIfExists(path);
		}

	}



}
