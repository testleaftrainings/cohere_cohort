package selenium.Day1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateNewDashboard_28 {

    @Test
    public void createNewDashboard() throws InterruptedException {

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
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        // Click view All and click Dashboards from App Launcher
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboard");
        WebElement eleDashboard = driver.findElement(By.xpath("//p[@class='slds-truncate']/ancestor::a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDashboard);

        // Click on the New Dashboard option
        driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
        Thread.sleep(5000);

        // Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.
        driver.switchTo().frame(0);
        WebElement inputField = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
        inputField.sendKeys("test");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

        // Click on Save and Verify Dashboard name.
        driver.findElement(By.xpath("//div[@class='slds-button-group']//button[text()='Save' and @class='slds-button slds-button_neutral save']")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebElement eleDone = driver.findElement(By.xpath("//button[@class='slds-button doneEditing']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDone);

    }
}

