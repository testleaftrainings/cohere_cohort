package sprint6_Logeshwari;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class S6_86_Newly_Created_PostDeleted {
    ChromeDriver driver;
    WebDriverWait wait;

    @Test //(retryAnalyzer = RetryEvent.class)
    public void deleteNewlyCreatedPost() throws MalformedURLException, InterruptedException {
           /* EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--disable-notifications");
            edgeOptions.setPlatformName("LINUX");
            DesiredCapabilities edgeDC = new DesiredCapabilities();
            edgeDC.setBrowserName("MicrosoftEdge");
            edgeDC.setPlatform(Platform.LINUX);
            edgeDC.setCapability(EdgeOptions.CAPABILITY, edgeOptions);

            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), edgeDC);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));*/


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // 1. Login to https://login.salesforce.com
        driver.get("https://login.salesforce.com/");

        // 2. Enter username as 'learners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
        driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        driver.findElement(By.id("Login")).click();


        // 3. Click on the 'File'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='home_Tab']"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='File']"))).click();
        String mainWindowHandle = driver.getWindowHandle();
        // 4. Click on 'Select a file from Salesforce'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //a[text()='Select a file from Salesforce']"))).click();

        // Switch to the new window
        Thread.sleep(2000);
        try {
            windowHandle(driver, 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            windowHandle(driver, 1);
        }

        // 5. Click on 'Owned by Me'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //span[text()='Owned by Me']"))).click();

        // 6. Search for 'Maven'
        WebElement eleMaven = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Search Files I Own...\"]")));
        eleMaven.sendKeys("Maven");
        eleMaven.sendKeys(Keys.ENTER);

        // 7. Click on the 'Attach' for Maven file
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='attach zen-first-child']/a"))).click();
        driver.switchTo().window(mainWindowHandle);

        // 8. Click on the 'Share' Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Share']"))).click();

        // 9. Click on the 'More Actions'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More Actions'][1]"))).click();

        // 10. Click on the 'File Sharing Settings'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='File Sharing Settings']"))).click();

        // 11. Change permissions as 'Collaborators'
        WebElement elePermission = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@title='Any user in your company']/parent::td)/following-sibling::td//span[@class='permissionLabel']"))));
        String permission = elePermission.getText();
        if (!permission.equalsIgnoreCase("Collaborators")) {
            elePermission.click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@title='Any user in your company']/parent::td)/following-sibling::td//span[@class='permissionLabel']")))).click();
        }

        // 12. Enable the checkBox for 'Prevent others from sharing and unsharing'
        WebElement eleCheckbox = driver.findElement(By.xpath("//input[@id='sharingOption']"));
        if (!eleCheckbox.isEnabled()) {
            eleCheckbox.click();
        }

        // 13. Verify the checkbox is Enabled
        Assert.assertTrue(eleCheckbox.isEnabled());

        // 14. Click on the 'Close' button.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"button\" and @value=\"Close\" ]"))).click();

        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
        // 15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=\"More Actions\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Topics']"))).click();
       // WebElement eleTopic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Add your own topics or choose from our suggestions.']")));
        Thread.sleep(5000);
       // eleTopic.sendKeys("Maven Installation Guide");

        WebElement eleTopic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='topicInput']//textarea")));
        wait.until(ExpectedConditions.elementToBeClickable(eleTopic));
        eleTopic.sendKeys("Maven Logeshwari");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title=\"Done\"]"))).click();

        // 16. Verify the Topics as 'Maven Installtion Guide'
        String eleTopicText = driver.findElement(By.xpath("//a[text()='Topics:']/following-sibling::a")).getText();
        Assert.assertTrue(eleTopicText.contains("Maven"), "The topic does not contain 'Maven'");

        // 17. Click on the widget dropdown for post and click 'Delete'
        String mainWindowHandle1 = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=\"More Actions\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Delete']"))).click();

        // 18. Click on the 'Ok' Button.
        Thread.sleep(2000);
        try {
            windowHandle(driver, 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            windowHandle(driver, 1);
        }
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='buttons'])//input[1]")));
        okButton.click();

        // 19. Verify the post is Deleted.
        driver.switchTo().window(mainWindowHandle1);
        List<WebElement> elePost = driver.findElements(By.xpath("//a[text()='Topics:']/following-sibling::a"));
        String post = "Logeshwari Maven";
        boolean postFound = false;

        for (WebElement postElement : elePost) {
            if (postElement.getText().equals(post)) {
                postFound = true;
                break;
            }
        }

        if (!postFound) {
            System.out.println("Post is deleted");
        } else {
            System.out.println("Post is present");
        }

        }

    public void windowHandle(RemoteWebDriver driver,int a) {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowList.get(a));
    }
}