package sprint6_Logeshwari;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateAccount_1 {

        @Test
        public void createAccount() throws InterruptedException, MalformedURLException {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            //ChromeDriver driver = new ChromeDriver(options);
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName("MicrosoftEdge");
            dc.setPlatform(Platform.LINUX);
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            driver.get("https://login.salesforce.com/");
            driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
            driver.findElement(By.id("password")).sendKeys("Leaf@123");
            driver.findElement(By.id("Login")).click();

            // 2. Click on the toggle menu button from the left corner
            driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

            // Click view All and click Sales from App Launcher
            driver.findElement(By.xpath("//button[text()='View All']")).click();
            driver.findElement(By.xpath("//p[text()='Sales']")).click();

            WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleAccounts);
            // Click on New button
            driver.findElement(By.xpath("//div[@title='New']")).click();

            // Enter 'your name' as account name
            driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Logeshwari");

            // Select Ownership as Public
            driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]")).click();

            // Click save and verify Account name
            driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
            Thread.sleep(2000);
            //String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
            //System.out.println(text);

            // Close the driver
            driver.quit();
        }
    }

