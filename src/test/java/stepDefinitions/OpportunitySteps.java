package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OpportunitySteps {

    ChromeDriver driver = new ChromeDriver();

    @Given("I am logged into Salesforce with username {string} and password {string}")
    public void loginToSalesforce(String username, String password) {
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("Login")).click();
    }

    @When("I create a new opportunity with name {string}")
    public void createNewOpportunity(String opportunityName) {
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement eleOpportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
        driver.executeScript("arguments[0].click();", eleOpportunities);

        driver.findElement(By.xpath("//a[@title='New']")).click();
        WebElement eleOpportunityName = driver.findElement(By.xpath("//label[text()='Opportunity Name']//following::input[1]"));
        eleOpportunityName.sendKeys(opportunityName);
    }

    @When("I set the close date to today")
    public void setCloseDate() {
        WebElement eleCloseDate = driver.findElement(By.xpath("//label[text()='Close Date']//following::input[1]"));
        eleCloseDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
    }

    @When("I select {string} as the stage")
    public void selectStage(String stage) {
        driver.findElement(By.xpath("//label[text()='Stage']//following::button[1]")).click();
        WebElement eleStage = driver.findElement(By.xpath("//span[text()='" + stage + "']"));
        eleStage.click();
    }

    @Then("the opportunity should be created successfully")
    public void verifyOpportunityCreation() {
        driver.findElement(By.xpath("//a[text()='Details']")).click();
        String actualOpportunityName = driver.findElement(By.xpath("(//span[text()='Opportunity Name']//following::lightning-formatted-text[contains(text(),'Salesforce Automation')])[2]")).getText();
        assert actualOpportunityName.contains("Salesforce Automation");
    }
}
