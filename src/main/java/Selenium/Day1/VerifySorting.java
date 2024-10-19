package selenium.Day1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class VerifySorting {

    @Test
    public void verifySorting(){
        // Set up Chrome options to disable notifications
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize the WebDriver with the options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        // Login to Login | Salesforce
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();

        // Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        // Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();

        WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleAccounts);

        //Click sort arrow in the Account Name to sort in ascending order
        WebElement sortingAccountName = driver.findElement(By.xpath("//a[@class='toggle slds-th__action slds-text-link--reset ']//span[text()='Account Name']/ancestor::a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortingAccountName);



    }




    /*
    Test Steps:
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Accounts tab
5. Click sort arrow in the Account Name to sort in ascending order
Expected Result:
All the accounts should be displayed ascending order by Account Name
Step Video:
https://drive.google.com/file/d/17ZCoOFSQJrw8SA_wXZw0mv7v0QaH_PkH/view?usp=sharing
     */
}
