package selenium.Day1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateLeadForCampaign_48 {


    ChromeDriver driver;
    WebDriverWait wait;

    @Test
    public void salesForce() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Login to https://login.salesforce.com
        driver.get("https://login.salesforce.com ");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();

        // Click on toggle menu button from the left corner
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

        // Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
        driver.findElement(By.xpath("//input[@role='combobox' and @placeholder='Search apps or items...']")).sendKeys("Sales");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//one-app-launcher-app-tile[@data-name='Sales']//mark[text()='Sales']")).click();

        // Click on Campaigns tab
        WebElement eleCampaigns = driver.findElement(By.xpath("//a[@title='Campaigns']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCampaigns);

        // Click Bootcamp link
        WebElement eleBootcamp = driver.findElement(By.xpath("//a[text()='Bootcamp']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleBootcamp);

        // Click Add Leads
        Thread.sleep(5000);
        WebElement eleAddLead = driver.findElement(By.xpath("(//div[@title='Add Leads'][normalize-space()='Add Leads'])"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eleAddLead);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleAddLead);

        // Click on New Lead
        Thread.sleep(5000);
        WebElement eleSearch = driver.findElement(By.xpath("//input[@role='combobox']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSearch);

        Thread.sleep(5000);
        WebElement eleNewLead = driver.findElement(By.xpath("//span[@title='New Lead']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleNewLead);

        // Pick Salutation as 'Mr.'
        Thread.sleep(5000);
        WebElement eleSalutation = driver.findElement(By.xpath("(//span[text()='Salutation']/parent::span)/following-sibling::div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']//a[@role='combobox']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSalutation);

        Thread.sleep(5000);
        WebElement eleMrs = driver.findElement(By.xpath("//a[@title='Mrs.']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleMrs);

        // Enter first name as <your First Name>
        Thread.sleep(5000);
        WebElement eleFirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleFirstName);
        eleFirstName.sendKeys("Logeshwari");

        // Enter last name as <your last name>
        Thread.sleep(5000);
        WebElement eleLastName = driver.findElement(By.xpath("//span[text()='Last Name']/parent::label/following-sibling::input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleLastName);
        eleLastName.sendKeys("Chandrasekaran");

        // Enter company as 'TestLeaf'
        Thread.sleep(5000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement eleCompany = driver.findElement(By.xpath("(//span[text()='Company']/parent::label)/following-sibling::input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eleCompany);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleCompany);
        //Thread.sleep(3000);
        eleCompany.sendKeys("Testleaf");

        // Click Save
        Thread.sleep(5000);
        WebElement eleSave = driver.findElement(By.xpath("//button[@title='Cancel']/following-sibling::button[@title='Save']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSave);

        // Click Next
        Thread.sleep(4000);
        WebElement eleNext = driver.findElement(By.xpath("//button[text()='Next']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleNext);

        // Click Submit on the Add to Campaign pop up
//        Thread.sleep(3000);
//        WebElement eleSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSubmit);

        // verify the created Lead under Campaign


        // Navigate to Leads tab

        // Search for Lead with your Name



    }
}