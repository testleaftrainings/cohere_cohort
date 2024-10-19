package frameworks;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateOpportunityOptimized {

    ChromeDriver driver;

    // Setup method to launch browser and Salesforce application
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
    }

    // Test to create an opportunity with parameterized data
    @Test
    @Parameters({ "username", "password", "opportunityNamePrefix" })
    public void createOpportunity(String username, String password, String opportunityNamePrefix) {
        try {
            // Step 1: Login
            loginToSalesforce(username, password);

            // Step 2: Open Sales App
            openAppLauncherAndSelectApp("Sales");

            // Step 3: Click on Opportunities Tab
            clickOnOpportunitiesTab();

            // Step 4: Create New Opportunity
            String opportunityName = opportunityNamePrefix + " " + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            createNewOpportunity(opportunityName);

            // Step 5: Verify Opportunity Name
            verifyOpportunityName(opportunityName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Reusable method to log in to Salesforce
    private void loginToSalesforce(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("Login")).click();
    }

    // Reusable method to open App Launcher and select the desired app
    private void openAppLauncherAndSelectApp(String appName) {
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='" + appName + "']")).click();
    }

    // Reusable method to click on Opportunities tab
    private void clickOnOpportunitiesTab() {
        WebElement eleOpportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
        driver.executeScript("arguments[0].click();", eleOpportunities);
    }

    // Method to create a new Opportunity
    private void createNewOpportunity(String opportunityName) throws Exception {
        // Click on New button
        driver.findElement(By.xpath("//a[@title='New']")).click();

        // Enter Opportunity Name
        WebElement eleOpportunityName = driver.findElement(By.xpath("//label[text()='Opportunity Name']//following::input[1]"));
        eleOpportunityName.sendKeys(opportunityName);

        // Enter Close Date as Today
        WebElement eleCloseDate = driver.findElement(By.xpath("//label[text()='Close Date']//following::input[1]"));
        eleCloseDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));

        // Select 'Stage' as Need Analysis
        driver.findElement(By.xpath("//label[text()='Stage']//following::button[1]")).click();
        WebElement eleStage = driver.findElement(By.xpath("//span[text()='Needs Analysis']"));
        eleStage.click();

        // Save Opportunity
        driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
    }

    // Method to verify if the opportunity name matches the expected value
    private void verifyOpportunityName(String expectedOpportunityName) {
        driver.findElement(By.xpath("//a[text()='Details']")).click();
        String actualOpportunityName = driver.findElement(By.xpath("(//span[text()='Opportunity Name']//following::lightning-formatted-text[contains(text(),'Salesforce Automation')])[2]")).getText();
        Assert.assertEquals(actualOpportunityName, expectedOpportunityName, "Opportunity Name Verification Failed");
    }

    // Cleanup method to close the browser
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

