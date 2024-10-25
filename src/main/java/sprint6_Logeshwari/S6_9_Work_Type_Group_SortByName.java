package sprint6_Logeshwari;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class S6_9_Work_Type_Group_SortByName {
    ChromeDriver driver;
    WebDriverWait wait;

    @Test
    public void workTypeGroup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("MicrosoftEdge");
        dc.setPlatform(Platform.LINUX);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // 1. Login to https://login.salesforce.com
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
        driver.findElement(By.id("Login")).click();

        // 2. Click on the toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        // 3. Click View All and click Work Type Groups from App Launcher
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
        WebElement eleType = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Work Type Groups']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleType);

        // Login to https://login.salesforce.com
        // Click on the toggle menu button from the left corner
        // Click View All and click Work Type Groups from App Launcher
        // Click on the Work Type Group tab
        // Click the sort arrow in the Work Type Group Name
        // Verify the Work Type Group displayed in ascending order by Work Type Group Name.




    }
}
