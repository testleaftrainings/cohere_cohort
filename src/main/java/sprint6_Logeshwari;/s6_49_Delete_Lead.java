package sprint6_Logeshwari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class s6_49_Delete_Lead {

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

        // Click on Leads tab
        driver.findElement(By.xpath("//a[@title='Leads']")).click();

        // Search for Lead with name as <your name>
        driver.findElement(By.xpath(""));

        // Click on dropdown icon for the Lead and Select Delete


        // Confirm the Delete for Lead


        // Click on Campaign tab


        // Click Bootcamp link


        // Verify the associated Lead


    }
    }
