package frameworks;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class CreateOppurtunityKeywordDrivenFramework {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void executeTest() throws IOException {
        // Path to the Excel file
        FileInputStream file = new FileInputStream("Keywords.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) {
            String action = formatter.formatCellValue(sheet.getRow(i).getCell(0));  // Action
            String locatorType = formatter.formatCellValue(sheet.getRow(i).getCell(1));  // Locator Type (id, xpath, etc.)
            String locatorValue = formatter.formatCellValue(sheet.getRow(i).getCell(2));  // Locator Value
            String data = formatter.formatCellValue(sheet.getRow(i).getCell(3));  // Data (text to enter, URL, etc.)

            performAction(action, locatorType, locatorValue, data);  // Execute each step
        }

        workbook.close();
    }

    // This method will perform the actual action based on the keyword read from the Excel file
    public void performAction(String action, String locatorType, String locatorValue, String data) {
        By locator = getBy(locatorType, locatorValue);  // Get the locator based on its type

        switch (action.toLowerCase()) {
            case "openapp":
                driver.get(data);  // Open a URL
                break;
            case "click":
                driver.findElement(locator).click();  // Click on an element
                break;
            case "sendkeys":
                driver.findElement(locator).sendKeys(data);  // Enter text in a field
                break;
            case "gettitle":
                System.out.println("Page title is: " + driver.getTitle());  // Fetch the page title
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }

    // Method to convert locator type (id, xpath, etc.) to By object
    public By getBy(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            default:
                throw new IllegalArgumentException("Unknown locator type: " + locatorType);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();  // Close the browser after the test
    }
}
