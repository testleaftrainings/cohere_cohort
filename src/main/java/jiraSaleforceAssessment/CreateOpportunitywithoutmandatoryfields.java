package jiraSaleforceAssessment;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOpportunitywithoutmandatoryfields extends BaseClass {
	public CreateOpportunitywithoutmandatoryfields(WebDriver driver) {
		this.driver=driver;
	}	
	@Test
	public  void saleForceStory() throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']")))).click();

		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();

		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Sales']")))).click(); 
		Thread.sleep(5000);

		WebElement oppEle = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",oppEle);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Close Date']//following::input[1]")).click();


		LocalDate tomorrow = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String tomorrowDate = tomorrow.format(formatter);

		WebElement dateElement = driver.findElement(By.xpath("//td[@data-value='" + tomorrowDate + "']//span[@role='button']"));
		dateElement.click();



	}


}
