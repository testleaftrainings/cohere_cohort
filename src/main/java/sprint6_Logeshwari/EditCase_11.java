package Selenium.Day1;

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



public class EditCase_11 {
    @Test
    public void editCase() {

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

        // 4. Click on Cases tab visible or select from more.
        WebElement eleMore = driver.findElement(By.xpath("//a[@class='slds-button slds-button_reset slds-context-bar__label-action']//span[text()='More']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleMore);

        WebElement eleCases = driver.findElement(By.xpath("//div[@class='slds-dropdown slds-dropdown_length-with-icon-10 slds-dropdown_right']//span[text()='Cases']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCases);

        // 5. Click on the Dropdown icon and select Edit from the case you created by reffering 'case owner alias'

        WebElement eleDropdown =  driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer']//a[@role='button'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDropdown);

        WebElement eleEdit =  driver.findElement(By.xpath("//a[@title='Edit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleEdit);

        // 6. Update Status as Working
        WebElement eleStatus =  driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div//button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleStatus);

        WebElement statusOption = driver.findElement(By.xpath("//div[@role='listbox']//lightning-base-combobox-item[@data-value='Working']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusOption);

        // 7. Update Priority to low
        WebElement elePriority = driver.findElement(By.xpath("(//label[text()='Priority']/parent::div)//button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elePriority);

        WebElement priorityOption = driver.findElement(By.xpath("//div[@aria-label='Priority']/lightning-base-combobox-item[@data-value='Low']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", priorityOption);

        // 8. Update Case Origin as Phone
        WebElement eleCaseOrigin = driver.findElement(By.xpath("(//label[text()='Case Origin']/parent::div)//button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCaseOrigin);

        WebElement caseOriginOption = driver.findElement(By.xpath("//div[@aria-label='Case Origin']/lightning-base-combobox-item[@data-value='Phone']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", caseOriginOption);

        // 9. Update SLA violation to No
        WebElement eleSlaViolation = driver.findElement(By.xpath("(//label[text()='SLA Violation']/parent::div)//button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSlaViolation);

        WebElement slaViolationOption = driver.findElement(By.xpath("//div[@aria-label='SLA Violation']/lightning-base-combobox-item[@data-value='No']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", slaViolationOption);

        // 10. Click on Save and Verify Status as Working
        WebElement eleSave = driver.findElement(By.xpath("(//ul[@class='slds-button-group-row']/li)//button[text()='Save']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSave);



        //driver.quit();

    }
}