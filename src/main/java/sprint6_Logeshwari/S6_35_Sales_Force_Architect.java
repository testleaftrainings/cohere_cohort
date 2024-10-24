package sprint6_Logeshwari;

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class S6_35_Sales_Force_Architect {

    ChromeDriver driver;
    WebDriverWait wait;

    @Test
    public void salesForce() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Launch Salesforce application.
        driver.get("https://login.salesforce.com");

        // Login with username and password.
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
        driver.findElement(By.id("Login")).click();

        // Click on Learn More link in Mobile Publisher
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Learn More']")).click();

        // Click confirm in the redirecting page.
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        driver.findElement(By.xpath("//button[text()='Confirm']")).click();

        // Click on the Learning and select Learning on trailhead
        Thread.sleep(2000);
        Shadow shadow = new Shadow(driver);
        shadow.findElementByXPath("//span[text()='Learning']").click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement learningOnTrailhead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
        actions.moveToElement(learningOnTrailhead).perform();
        Thread.sleep(2000);

        // Click on  Salesforce Certification
        WebElement salesCertification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
        salesCertification.click();

        // Select Salesforce Architect.
        Thread.sleep(2000);
        WebElement eleSaleForceArchitect = driver.findElement(By.xpath("//div[@class='roleMenu-item_text' and text()='Architect' and text() ='Salesforce']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleSaleForceArchitect);

        // Verify the Page title after selecting Architect
        String salesforceArchitect = driver.findElement(By.xpath("//div[@class='cert-site_title slds-p-top--large']//h1")).getText();
        if (salesforceArchitect.equals("Salesforce Architect Credentials")){
            System.out.println("Heading Matching");
        }else {
            System.out.println("Heading does not matching");
        }

        // Verify the Certifications listed for Architect""
        List<WebElement> certifications = driver.findElements(By.xpath("//div[@class='slds-container--center slds-container--x-large slds-p-top--small']//div[@class='credentials-card_title']"));
        for (WebElement certification : certifications){
            String certificationTitle = certification.getText();
            System.out.println(certificationTitle);
        }

//        List<String> titlesToCheck = List.of(
//                "Application Architect",
//                "B2C Commerce Architect",
//                "Heroku Architecture Designer",
//                "System Architect",
//                "Technical Architect"
//        );
//
//        // Check for each title in the list
//        for (String title : titlesToCheck) {
//            if (certificationTitles.contains(title)) {
//                System.out.println(title + " is present.");
//            } else {
//                System.out.println(title + " is NOT present.");
//            }
//        }
//    }
//}
        /*
                                                         Expected Result:

Page title should be chaged to ""Certification - Architect Overview""

Below Certifications should be displayed
a) Application Architect
b) B2C Commerce Architect
c) Heroku Architecture Designer
d) System Architect
e) Technical Architect
         */
    }
}
