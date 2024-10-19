package Selenium.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cheap0Air {

        public static void main(String[] args) throws InterruptedException {
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            // https://www.cheapoair.com/
            driver.get("https://www.cheapoair.com/");
            Thread.sleep(5000);

            // Select one way trip
            WebElement eleOneWayTrip =  driver.findElement(By.id("onewayTrip"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleOneWayTrip);

            // Select Destination
            driver.findElement(By.id("from0")).sendKeys("MAA", Keys.TAB);
            WebElement textBox=driver.findElement(By.id("to0"));
            textBox.click();
            textBox.sendKeys("BLR",Keys.ENTER);

            // Select Travel date
            driver.findElement(By.xpath("//input[@aria-label='Choose a departure date. expanded']")).click();
            driver.findElement(By.xpath("//a[@class=' month-date is--today']")).click();
            driver.findElement(By.xpath("//div[text()='Traveler']")).click();

            // Select 2 adults & Click on Done
            driver.findElement(By.id("addadults")).click();
            driver.findElement(By.id("closeDialog")).click();

            // Click search Flights
            driver.findElement(By.id("searchNow")).click();

            // Write a logic to find the lowest price and Select the lowest price flight
            List<WebElement> allElements = driver.findElements(By.xpath("//span[@class='currency text-nowrap ']"));
            List<Double> allPrice = new ArrayList<Double>();
            for (WebElement eachEle : allElements) {
                String priceInString = eachEle.getAttribute("title");
                double priceInDouble = Double.parseDouble(priceInString);
                allPrice.add(priceInDouble);
            }
            if (!allPrice.isEmpty()) {
                Collections.sort(allPrice);
                Double least = allPrice.get(0);
                driver.findElement(By.xpath("//span[contains(@title,'" + least + "')]/following::span[text()='Select']")).click();
            } else {
                System.out.println("No prices found.");
            }

        }
}
/*
 * https://www.cheapoair.com/
 *1. Select one way trip
 *2. Select Destination
 *3. Select Travel date
 *4. Select 2 adults & Click on Done
 *5. Click search Flights
 *6. Write a logic to find the lowest price and Select the lowest price flight
 */