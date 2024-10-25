package sprint6_Logeshwari;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import sprint6_Rajesh.RetryEvent;



public class S6_11_Edit_Case {
    @Test (retryAnalyzer = RetryEvent.class)
    public void editCase() throws MalformedURLException, InterruptedException {
    	EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
        //ChromeDriver driver = new ChromeDriver(options);
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("MicrosoftEdge");
        dc.setPlatform(Platform.LINUX);
        dc.setCapability(ChromeOptions.CAPABILITY, edgeOptions);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        

        // 1. Login to https://login.salesforce.com
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
        driver.findElement(By.id("Login")).click();

        // 2. Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        // 3. Click view All and click Sales from App Launcher
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Sales']"))).click();
       

        // 4. Click on Cases tab visible or select from more.
        Thread.sleep(3000);
        WebElement eleMore = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
//        WebElement eleMore = driver.findElement(By.xpath("//span[text()='More']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleMore);
        Thread.sleep(2000);
        WebElement eleCases = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Cases']")));
//        WebElement eleCases = driver.findElement(By.xpath("//div[@class='slds-dropdown slds-dropdown_length-with-icon-10 slds-dropdown_right']//span[text()='Cases']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCases);

        // 5. Click on the Dropdown icon and select Edit from the case you created by reffering 'case owner alias'
        WebElement eleDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@class='slds-cell-edit cellContainer']//a[@role='button'])[1]")));
//        WebElement eleDropdown =  driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer']//a[@role='button'])[1]"));
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



        driver.quit();

    }
}