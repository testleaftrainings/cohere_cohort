package sprint6_Gokul;

import java.util.Set;

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


public class CustomerServiceOptions33 {

//	ChromeDriver driver = new ChromeDriver();
	static RemoteWebDriver driver ;
	@Test
	public void customerServiceMethod() throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("MicrosoftEdge");
        dc.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//article[@data-aura-class=\"onesetupHelpTile\"]//span[text()='Learn More']"))
				.click();
		Set<String> s = driver.getWindowHandles();
		String window = "";
		for (String s1 : s) {
			window = s1;
		}

		driver.switchTo().window(window);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		String prds = "Products";
		String cpys = "Company";
		String sups = "Support";
		Shadow sDrive = new Shadow(driver);
//			WebElement mobile = 
//					sDrive.findElementByXPath(("//span[text()='Company']")).click();

//			int in = sDrive.findElementsByXPath("//span[text()='Support']").size();
//			System.out.println(in);
		Thread.sleep(2000);
		String sup = sDrive.findElementByXPath("//span[text()='Support']").getText();
//			System.out.println(sup);
		String prd = sDrive.findElementByXPath("//span[text()='Products']").getText();
		String cpy = sDrive.findElementByXPath("//span[text()='Company']").getText();

		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(sups, sup, "Not present");
		sAssert.assertEquals(prds, prd, "Not present");
		sAssert.assertEquals(cpys, cpy, "Not present");
		sAssert.assertAll();

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
