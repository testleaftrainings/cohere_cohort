package sprint6_Logeshwari;

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

public class s6_29_Edit_Dashboard {

    @Test
    public void editDashboard() throws InterruptedException {
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

        // Click view All and click Dashboards from App Launcher
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboard");
        WebElement eleDashboard = driver.findElement(By.xpath("//p[@class='slds-truncate']/ancestor::a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDashboard);

        // Search the Dashboard 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_left']//input")).sendKeys("Logeshwari");
        Thread.sleep(5000);

        // Click on the Dropdown icon and Select Edit
        WebElement eleDropdown = driver.findElement(By.xpath("(//tr[@role='row']//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread'])//button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDropdown);

        WebElement eleEdit = driver.findElement(By.xpath("//span[text()='Edit']/parent::a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleEdit);
        Thread.sleep(10000);

        // Click on the Edit Dashboard Properties icon
        driver.switchTo().frame(0);
        WebElement eleEditIcon = driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleEditIcon);

        // Enter Description as 'SalesForce' and click on save
        driver.findElement(By.xpath("(//label[text()='Description']/parent::div)//input")).sendKeys("SalesForce");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

        // Click on Done and  Click on save in the popup window displayed
        WebElement eleDone = driver.findElement(By.xpath("//button[@class='slds-button doneEditing']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDone);

        driver.findElement(By.xpath("//button[@id='modalBtn2']")).click();

        // Verify the Description
        String description = driver.findElement(By.xpath("//div[@class='slds-col slds-align-bottom']//p")).getText();
        System.out.println(description);
    }

}
/*
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the Dashboards tab
5. Search the Dashboard 'Salesforce Automation by *Your Name*'
6. Click on the Dropdown icon and Select Edit
7.Click on the Edit Dashboard Properties icon
8. Enter Description as 'SalesForce' and click on save.
9. .
10. .
Expected Result: The Dashboard is Edited Successfully
Step Video: https://drive.google.com/file/d/1G0jv2KquvgDXsrGOMFMeUiNng4wL_Pv1/view?usp=sharing
 */