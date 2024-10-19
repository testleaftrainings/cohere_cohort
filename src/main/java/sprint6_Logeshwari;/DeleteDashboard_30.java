package Selenium.Day1;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DeleteDashboard_30 {
    ChromeDriver driver;
    WebDriverWait wait;

@Test
    public void deleteDashboard(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    // Login to https://login.salesforce.com
    // Click on the toggle menu button from the left corner
    // Click View All and click Dashboards from App Launcher
    // Click on the Dashboards tab
    // Search the Dashboard 'Salesforce Automation by *Your Name*'
    // Click on the Dropdown icon and Select Delete
    // Click on the Delete option in the displayed popup window.
    // Verify Whether Dashboard is Deleted using Dashboard Name
    // Expected Result: The Dashboard is deleted Successfully
    // Step Video: https://drive.google.com/file/d/1f8fUhwRQPP7ap7YRC0XOKeF_6UezMF8X/view?usp=sharing

}

}
