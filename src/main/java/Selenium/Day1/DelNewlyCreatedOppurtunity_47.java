package Selenium.Day1;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class DelNewlyCreatedOppurtunity_47 {

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

        // Click on the dropdown icon in the Opportunities
        WebElement eleDropdown = driver.findElement(By.xpath("((//a[text()='Logeshwari Test']/ancestor::th)/following-sibling::td)//span[text()='Show Actions']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDropdown);

        // Select Delete and Confirm the delete
        Thread.sleep(2000);
        WebElement eleDelete = driver.findElement(By.xpath("//div[@title='Delete']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleDelete);

        WebElement elePopupDelete = driver.findElement(By.xpath("//button[@title='Delete']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elePopupDelete);


        // Verify the Deleted Opportunity under selected campaign
        String text = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
        System.out.println(text);

        // Search for created oppurtunity and verify its deleted or not
        driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search this list...']")).sendKeys("Logeshwari");
        driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search this list...']")).sendKeys(Keys.ENTER);
        // Verify the deleted Opportunity
        WebElement noItemsMessage = driver.findElement(By.xpath("//span[text()='No items to display.']"));
        if (noItemsMessage.isDisplayed()) {
            System.out.println("The message 'No items to display.' is present.");
        } else {
            System.out.println("The message is not displayed.");
        }

    }

}