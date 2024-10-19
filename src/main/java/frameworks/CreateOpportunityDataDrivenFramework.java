//package frameworks;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.Date;
//
//public class CreateOpportunityDataDrivenFramework {
//
//    ChromeDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.manage().window().maximize();
//        driver.get("https://login.salesforce.com/");
//    }
//
//    @Test(dataProvider = "opportunityData")
//    public void createOpportunity(String username, String password, String opportunityNamePrefix) {
//        loginToSalesforce(username, password);
//
//        openAppLauncherAndSelectApp("Sales");
//        clickOnOpportunitiesTab();
//        createNewOpportunity(opportunityNamePrefix);
//        verifyOpportunityName(opportunityNamePrefix);
//    }
//
//    public void loginToSalesforce(String username, String password) {
//        driver.findElement(By.id("username")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.id("Login")).click();
//    }
//
//    public void openAppLauncherAndSelectApp(String appName) {
//        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
//        driver.findElement(By.xpath("//button[text()='View All']")).click();
//        driver.findElement(By.xpath("//p[text()='" + appName + "']")).click();
//    }
//
//    public void clickOnOpportunitiesTab() {
//        WebElement eleOpportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
//        driver.executeScript("arguments[0].click();", eleOpportunities);
//    }
//
//    public void createNewOpportunity(String opportunityNamePrefix) {
//        driver.findElement(By.xpath("//a[@title='New']")).click();
//        WebElement eleOpportunityName = driver.findElement(By.xpath("//label[text()='Opportunity Name']//following::input[1]"));
//        eleOpportunityName.sendKeys(opportunityNamePrefix + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//
//        WebElement eleCloseDate = driver.findElement(By.xpath("//label[text()='Close Date']//following::input[1]"));
//        eleCloseDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
//
//        driver.findElement(By.xpath("//label[text()='Stage']//following::button[1]")).click();
//        WebElement eleStage = driver.findElement(By.xpath("//span[text()='Needs Analysis']"));
//        eleStage.click();
//
//        driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
//    }
//
//    public void verifyOpportunityName(String expectedOpportunityName) {
//        driver.findElement(By.xpath("//a[text()='Details']")).click();
//        String actualOpportunityName = driver.findElement(By.xpath("(//span[text()='Opportunity Name']//following::lightning-formatted-text[contains(text(),'Salesforce Automation')])[2]")).getText();
//        assert actualOpportunityName.contains(expectedOpportunityName);
//    }
//
//    @DataProvider(name = "opportunityData")
//    public Object[][] getData() throws IOException {
//        FileInputStream file = new FileInputStream("OpportunityData.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        DataFormatter formatter = new DataFormatter();
//
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        Object[][] data = new Object[rowCount - 1][3];
//
//        for (int i = 1; i < rowCount; i++) {
//            data[i - 1][0] = formatter.formatCellValue(sheet.getRow(i).getCell(0));
//            data[i - 1][1] = formatter.formatCellValue(sheet.getRow(i).getCell(1));
//            data[i - 1][2] = formatter.formatCellValue(sheet.getRow(i).getCell(2));
//        }
//
//        workbook.close();
//        return data;
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}
