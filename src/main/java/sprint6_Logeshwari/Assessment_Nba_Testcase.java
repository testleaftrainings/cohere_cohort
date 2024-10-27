package sprint6_Logeshwari;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Assessment_Nba_Testcase {
    ChromeDriver driver;
    WebDriverWait wait;

    @Test
    public void nbaTest() throws InterruptedException, MalformedURLException {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--disable-notifications");
            edgeOptions.setPlatformName("LINUX");
            DesiredCapabilities edgeDC = new DesiredCapabilities();
            edgeDC.setBrowserName("MicrosoftEdge");
            edgeDC.setPlatform(Platform.LINUX);
            edgeDC.setCapability(EdgeOptions.CAPABILITY, edgeOptions);

            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.193:8080/wd/hub"), edgeDC);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 1. Navigate to https://www.nba.com/stats
        driver.get("https://www.nba.com/stats");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']"))).click();

        // 2. Click on 'See All Player Stats'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='See All Player Stats']"))).click();
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='bx-close bx-close-link bx-close-inside'])[2]"))).click();

        // 3. Choose 'Season' as '2023-24'
        WebElement seasonDropdown = driver.findElement(By.xpath("(//p[text()='Season']/parent::label)//select"));
        Select seasonSelect = new Select(seasonDropdown);
        seasonSelect.selectByVisibleText("2023-24");

        // 4. Choose 'Season Type' as 'NBA Cup'
        WebElement seasonTypeDropdown = driver.findElement(By.xpath("(//p[text()='Season Type']/parent::label)//select"));
        Select seasonTypeSelect = new Select(seasonTypeDropdown);
        seasonTypeSelect.selectByVisibleText("NBA Cup");

        // 5. Choose 'Per Mode' as 'Per Game'
        WebElement perModeDropdown = driver.findElement(By.xpath("(//p[text()='Per Mode']/parent::label)//select"));
        Select perModeSelect = new Select(perModeDropdown);
        perModeSelect.selectByVisibleText("Per Game");

        // 6. Choose 'Season Segment' as 'Last Game'
        WebElement seasonSegmentDropdown = driver.findElement(By.xpath("(//p[text()='Season Segment']/parent::label)//select"));
        Select seasonSegmentSelect = new Select(seasonSegmentDropdown);
        seasonSegmentSelect.selectByVisibleText("Last Game");

        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='bx-close bx-close-link bx-close-inside']"))).click();


        // 7. Click on the player name with lowest age
        WebElement ageHeader = driver.findElement(By.xpath("//th[text()='Age']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ageHeader);
        List<WebElement> eleAgeList = driver.findElements(By.xpath("//td[@class='Crom_text__NpR1_']/following-sibling::td[1]"));
        List<WebElement> elePlayers = driver.findElements(By.xpath("//td[@class='Crom_text__NpR1_ Crom_primary__EajZu Crom_stickySecondColumn__29Dwf']"));
        int lowestAge = Integer.MAX_VALUE;
        String playerName = "";

        for (int i = 0; i < eleAgeList.size(); i++) {
            String ageText = eleAgeList.get(i).getText();
            int age;
            try {
                age = Integer.parseInt(ageText);
                if (age < lowestAge) {
                    lowestAge = age;
                    playerName = elePlayers.get(i).getText();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format: " + ageText);
            }
        }

        if (lowestAge != Integer.MAX_VALUE) {
            System.out.println("The youngest player is: " + playerName + " with age: " + lowestAge);
        } else {
            System.out.println("No valid age found.");
        }


        // 8. Click on the Profile
        boolean playerFound = false;
        for (WebElement player : elePlayers) {
            if (player.getText().equals(playerName)) {
                player.click();
                playerFound = true;
                break;
            }
        }
        if (!playerFound) {
            System.out.println("Player not found in the list.");
        }

        // 9. Get the Experience of the player
        WebElement experienceElement = driver.findElement(By.xpath("(//p[text()='EXPERIENCE'])[1]/following-sibling::p"));
        String experienceText = experienceElement.getText().trim();

        // 10. Verify the player experience as 1
        int experience = 0;
        try {

            String numericPart = experienceText.replaceAll("[^0-9]", "");
            if (!numericPart.isEmpty()) {
                experience = Integer.parseInt(numericPart);
            }

            if (experience == 1) {
                System.out.println("Player experience is verified as 1 year.");
            } else {
                System.out.println("Player experience is not 1 year, it is: " + experience);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid experience format: " + experienceText);
        }
    }
}
