package sprint6_Rajeev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class S6_Verify_NBA_Stats_Sort_Age {

    @Test
    public void Newly_Created() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.nba.com/stats");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'I Accept')]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'See All Player Stats')]"))).click();


        HashMap<Integer, String> playerInfo = new HashMap<>();


        List<WebElement> players = new ArrayList<>();
        players = driver.findElements(By.xpath("//a[contains(@href,'/stats/player/')]"));

        List<WebElement> playersAge = new ArrayList<>();
        playersAge = driver.findElements(By.xpath("//a[contains(@href,'/stats/player/')]/following::td[2]"));

        System.out.println("count of players " + players.size());

        for (int i = 0; i < players.size(); i++) {

            System.out.println("players " + players.get(i).getText());
            playerInfo.put(Integer.valueOf(playersAge.get(i).getText()), players.get(i).getText());

        }

        String playerLowestAge = null;
        SortedSet<Integer> keys = new TreeSet<>(playerInfo.keySet());
        for (Integer key : keys) {
            String value = playerInfo.get(key);
            System.out.println("plsayerSort " + value);

            playerLowestAge = value;
            break;
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" (//button[contains(@id,'bx-close-inside')])[last()]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + playerLowestAge + "')]"))).click();
        Thread.sleep(3000);

        System.out.println("yrofExp " + driver.findElement(By.xpath("(//p[contains(text(),'EXPERIENCE')]/following::p[1])[1]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("(//p[contains(text(),'EXPERIENCE')]/following::p[1])[1]")).getText().contains("1 Year"));

    }

}