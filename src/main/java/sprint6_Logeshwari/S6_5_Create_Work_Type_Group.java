package sprint6_Logeshwari;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_5_Create_Work_Type_Group {

    @Test
    public void CreateWorkTypeGroup() {
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

        // 2. Click on the toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        // 3. Click View All and click Work Type Groups from App Launcher
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
        WebElement eleType = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Work Type Groups']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleType);

        // 4. Click on the Dropdown icon in the Work Type Groups tab
        driver.findElement(By.xpath("(//a[@title='Recently Viewed | Work Type Groups']//following-sibling::one-app-nav-bar-item-dropdown)[2]//one-app-nav-bar-menu-button/a")).click();

        // 5. Click on New Work Type Group
        WebElement eleNewWorkTypeGroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleNewWorkTypeGroup);

        // 6. Enter Work Type Group Name as 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//input[@class='slds-input' and @name='Name']")).sendKeys("Logeshwari");

        // 7.Click save and verify Work Type Group Name
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        WebElement text1= driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text[@slot='primaryField']"));
        System.out.println(text1.getText());

        //driver.quit();



    }
}
