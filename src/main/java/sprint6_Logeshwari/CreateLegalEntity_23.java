package Selenium.Day1;

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

public class CreateLegalEntity_23 {

    @Test
    public void createLegalEntity() throws InterruptedException {
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

        // Click view All and click Legal Entities from App Launcher
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
        WebElement eleType = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Legal Entities']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleType);

        // Click on the Dropdown icon in the legal Entities tab
        WebElement eleEntityDropdown = driver.findElement(By.xpath("(//a[@title='Recently Viewed | Legal Entities']//following-sibling::one-app-nav-bar-item-dropdown)[2]//one-app-nav-bar-menu-button/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleEntityDropdown);


        // Click on New Legal Entity
        //driver.findElement(By.xpath("//span[text()='New Legal Entity']//preceding-sibling::lightning-icon")).click();

        WebElement eleNewLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']//preceding-sibling::lightning-icon"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleNewLegalEntity);


        // Enter Name as 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("(//label[text()='Legal Entity Name']//following-sibling::div)/input[@name='Name']")).sendKeys("Logeshwari");

       // Click save and verify Legal Entity Name
        driver.findElement(By.xpath("//ul[@class='slds-button-group-row']//button[text()='Save']")).click();
        String entityName = driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
        System.out.println(entityName);



    }
    /*
    Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Legal Entities from App Launcher
4. Click on the Dropdown icon in the legal Entities tab
5. Click on New Legal Entity
6. Enter Name as 'Salesforce Automation by *Your Name*'
7.Click save and verify Legal Entity Name
Expected Result:The Legal Entity is created Successfully
Step Video: https://drive.google.com/file/d/1JoZH4TIpasqcF4E2XfZIy-46iut9ApPm/view?usp=sharing
     */
}
