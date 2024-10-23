package sprint6_Logeshwari;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class S6_17_Create_Oppurtunity {

    @Test
    public void createOppurtunity(){

        // Set up Chrome options to disable notifications
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize the WebDriver with the options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        // 1. Login to https://login.salesforce.com
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();

        // 2. Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        // 3. Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();

        // 4. Click on Opportunity tab
        WebElement eleOppurtunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleOppurtunity);

        // 5. Click on New button
        WebElement eleNew = driver.findElement(By.xpath("//a[@title='New']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleNew);

        // 6. Choose Close date as Tomorrow Date
        WebElement eleCloseDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCloseDate);

        WebElement selectDate = driver.findElement(By.xpath("(//td[@aria-current='date']/following-sibling::td[@aria-current='false'])//span[@role='button']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectDate);

        // 7. Click on save
        WebElement eleSave = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSave);

        WebElement eleClose = driver.findElement(By.xpath("//button[@title='Close error dialog']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleClose);

        // 8. Verify the Alert message (Complete this field) displayed for Name and Stage
        String eleOppurtunityName = driver.findElement(By.xpath("(//label[text()='Opportunity Name']/parent::div)/following-sibling::div[text()='Complete this field.']")).getText();
        String eleStage = driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[text()='Complete this field.']")).getText();

        System.out.println(eleOppurtunityName);
        System.out.println(eleStage);



    }

}
