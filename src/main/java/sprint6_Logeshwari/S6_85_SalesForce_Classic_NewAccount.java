package sprint6_Logeshwari;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class S6_85_SalesForce_Classic_NewAccount {
    ChromeDriver driver;
    WebDriverWait wait;

    @Test //(retryAnalyzer = RetryEvent.class)
    public void classicNewAccount() throws MalformedURLException, InterruptedException {
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

        // 3. Choose 'Account' from the dropdown
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='home_Tab']"))).click();
        WebElement dropdownElement = driver.findElement(By.id("createNewSelect"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Account");

        // 4. Click on the 'Go!' button.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='createNewSelect']/following-sibling::input[@title=\"Go!\"]"))).click();

        // 5. Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Account Name']/parent::td)//following-sibling::td//div[@class='requiredInput']//input"))).sendKeys("BootCamp Puppeteer_Logeshwari");

        // 6. Enter the Billing Address
        WebElement billingStreet = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//label[text()='Billing Street']//parent::td//following-sibling::td)//textarea)[1]")));
        billingStreet.sendKeys("Sheela Nagar");

        WebElement billingCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(((//label[text()='Billing City']/parent::td)/following-sibling::td)//input)[1]")));
        billingCity.sendKeys("Chennai");

        WebElement billingZip = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(((//label[text()='Billing Zip/Postal Code']/parent::td)/following-sibling::td)//input)[1]")));
        billingZip.sendKeys("600091");

        WebElement billingState = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(((//label[text()='Billing State/Province']/parent::td)/following-sibling::td)//input)[1]")));
        billingState.sendKeys("Tamil Nadu");

        WebElement billingCountry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(((//label[text()='Billing Country']/parent::td)/following-sibling::td)//input)[1]")));
        billingCountry.sendKeys("India");

        // 7. Click Copy Billing Address to Shipping Address link
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Copy Billing Address to Shipping Address']"))).click();

        // 8. Verify the Shipping Address reflects the Billing Address

        // Verify Shipping Street
        WebElement shippingStreet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//label[text()='Shipping Street']//parent::td//following-sibling::td)//textarea)[1]")));
        String expectedStreet = "Sheela Nagar";
        String actualStreet = shippingStreet.getAttribute("value");
        assert expectedStreet.equals(actualStreet) : "Shipping Street does not match Billing Street";

        // Verify Shipping City
        WebElement shippingCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//label[text()='Shipping City']/parent::td)/following-sibling::td)//input)[1]")));
        String expectedCity = "Chennai";
        String actualCity = shippingCity.getAttribute("value");
        assert expectedCity.equals(actualCity) : "Shipping City does not match Billing City";

        // Verify Shipping Zip
        WebElement shippingZip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//label[text()='Shipping Zip/Postal Code']/parent::td)/following-sibling::td)//input)[1]")));
        String expectedZip = "600091";
        String actualZip = shippingZip.getAttribute("value");
        assert expectedZip.equals(actualZip) : "Shipping Zip does not match Billing Zip";

        // Verify Shipping State
        WebElement shippingState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//label[text()='Shipping State/Province']/parent::td)/following-sibling::td)//input)[1]")));
        String expectedState = "Tamil Nadu";
        String actualState = shippingState.getAttribute("value");
        assert expectedState.equals(actualState) : "Shipping State does not match Billing State";

        // Verify Shipping Country
        WebElement shippingCountry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//label[text()='Shipping Country']/parent::td)/following-sibling::td)//input)[1]")));
        String expectedCountry = "India";
        String actualCountry = shippingCountry.getAttribute("value");
        assert expectedCountry.equals(actualCountry) : "Shipping Country does not match Billing Country";

        System.out.println("All shipping address fields match billing address fields!");

        // 9. Enter the SLA Expiration Date as Current Date + 20 days
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //span[@class='dateInput dateOnlyInput']"))).click();

        // Calculate the target date (today + 20 days)
        LocalDate targetDate = LocalDate.now().plusDays(20);
        String targetDateText = String.valueOf(targetDate.getDayOfMonth()); // Get the day of the month as a string

        // Locate and select the target date element
        WebElement futureDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + targetDateText + "']")));
        futureDateElement.click();

        System.out.println("Selected date: " + targetDateText);

        // 10. Click on Save button.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"))).click();

        // 11. Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
        String formHeaderText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='textBlock']//h2"))).getText();
        String expectedHeader = "BootCamp Puppeteer_Logeshwari";
        assert expectedHeader.equals(formHeaderText) : "Actual Header does not match Expected Header. Expected: " + expectedHeader + ", Actual: " + formHeaderText;
        System.out.println("Form Header: " + formHeaderText);

        // 12. Navigate to Accounts tab and Verify the newly Created account is displayed
        driver.findElement(By.xpath("//a[@title='Accounts Tab - Selected']")).click();
        List<WebElement> headerElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//th[@scope='row']")));
        boolean headerFound = false;

        for (WebElement header : headerElements) {
            if (header.getText().contains(expectedHeader)) {
                headerFound = true;
                break;
            }
        }

        // 13. Close the browser Expected Result: Verify the newly Created account is displayed
        if (headerFound) {
            System.out.println("The newly created account '" + expectedHeader + "' is displayed in the Accounts tab.");
        } else {
            System.out.println("The newly created account '" + expectedHeader + "' is NOT found in the Accounts tab.");
        }
        driver.quit();
    }
}

