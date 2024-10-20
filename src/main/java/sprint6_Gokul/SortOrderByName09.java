package sprint6_Gokul;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SortOrderByName09 {

	ChromeDriver driver = new ChromeDriver();

	@Test
	public void createAccMthd() throws InterruptedException {
//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement workType = driver.findElement(By.xpath("//li//p[text()='Work Type Groups']"));
		action.moveToElement(workType).perform();
		workType.click();
		Thread.sleep(5000);
		String count = driver.findElement(By.xpath("//span[@role='status']")).getText();
		String[] str = count.split("\\s");
		String str1 = str[0];
		str1 = str1.replaceAll("[^0-9]", "");
		int countNum = Integer.parseInt(str1);

		System.out.println(countNum);
		Thread.sleep(5000);
		int size = driver.findElements((By.xpath("//a[@data-refid=\"recordId\"]"))).size();
		System.out.println(size);
		while (size != countNum) {
			size = driver.findElements((By.xpath("//a[@data-refid=\"recordId\"]"))).size();
			System.out.println(size);
			List<WebElement> numlists = driver.findElements((By.xpath("//a[@data-refid=\"recordId\"]")));
			for (WebElement numlist : numlists) {

				action.moveToElement(numlist).perform();
				System.out.println(numlist.getText());
				count = driver.findElement(By.xpath("//span[@role='status']")).getText();
				str = count.split("\\s");
				str1 = str[0];
				str1 = str1.replaceAll("[^0-9]", "");
				countNum = Integer.parseInt(str1);
				System.out.println(countNum);

			}
		}
		List<String> li = new ArrayList<String>();
		List<WebElement> numlists = driver.findElements((By.xpath("//a[@data-refid=\"recordId\"]")));
		for (WebElement numlist : numlists) {

			action.moveToElement(numlist).perform();
			String nme = numlist.getText();
			System.out.println(nme);
			li.add(nme);
		}
		System.out.println(li);
		Collections.sort(li, String.CASE_INSENSITIVE_ORDER);
		System.out.println(li);
		WebElement workType1 = driver.findElement(By.xpath("(//a//span[@title='Work Type Group Name'])"));
		driver.executeScript("arguments[0].click();", workType1);
		Thread.sleep(5000);

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
