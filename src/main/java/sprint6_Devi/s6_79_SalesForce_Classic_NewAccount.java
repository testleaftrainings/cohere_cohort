package sprint6_Devi;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class s6_79_SalesForce_Classic_NewAccount {
	@Test
	public void createClassicNewAccount() {
		String accountName="BootCamp Puppeteer_Devi";
		String billingStreet="124 SDET street";
		String billingCity="SDET";
		String billingZipCode="2024";
		String billingState="Chennai";
		String billingCountry="India";
		ChromeDriver driver = new ChromeDriver();
		//Step 1: 1. Navigate to Salesforce login page
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Step 2 Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		//Step 3. Choose 'Account' from the dropdown
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
	
		//WebElement options = driver.findElement(By.xpath("//select[@id='createNewSelect']"));

		//Select selObj = new Select(options);
        //selObj.selectByValue("Account");
		driver.findElement(By.xpath("//select[@id='createNewSelect']")).click();
		driver.findElement(By.xpath("//select[@id='createNewSelect']//option[text()='Account']")).click();
        
		//Step 4. Click on the 'Go!' button.
        driver.findElement(By.xpath("//select[@id='createNewSelect']/following-sibling::input[@title='Go!']")).click();
        
		//Step 5. Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys(accountName);
		
		//Step 6. Enter the Billing Address
        WebElement eleBillingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::td[1]/textarea"));
        eleBillingStreet.sendKeys(billingStreet);
        WebElement eleBillingCity = driver.findElement(By.xpath("//label[text()='Billing City']/following::input[1]"));
        eleBillingCity.sendKeys(billingCity);
        WebElement eleBillingZip = driver.findElement(By.xpath("//label[text()='Billing Zip/Postal Code']/following::input[1]"));
        eleBillingZip.sendKeys(billingZipCode);
        WebElement eleBillingState = driver.findElement(By.xpath("//label[text()='Billing State/Province']/following::input[1]"));
        eleBillingState.sendKeys(billingState);
        WebElement eleBillingCpuntry = driver.findElement(By.xpath("//label[text()='Billing Country']/following::input[1]"));
        eleBillingCpuntry.sendKeys(billingCountry);
        
		//Step 7. Click Copy Billing Address to Shipping Address link
        driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();
        
        WebElement eleShippingStreet = driver.findElement(By.xpath("//label[text()='Shipping Street']/following::td[1]/textarea"));
        WebElement eleShippingCity = driver.findElement(By.xpath("//label[text()='Shipping City']/following::input[1]"));
        WebElement eleShippingZip = driver.findElement(By.xpath("//label[text()='Shipping Zip/Postal Code']/following::input[1]"));
        WebElement eleShippingState = driver.findElement(By.xpath("//label[text()='Shipping State/Province']/following::input[1]"));
        WebElement eleShippingCountry = driver.findElement(By.xpath("//label[text()='Shipping Country']/following::input[1]"));
        
    	
		//Step 8. Verify the Shipping Address reflects the Billing Address
        String billingStreetValue = eleBillingStreet.getText();
        String billingCityValue = eleBillingCity.getAttribute("value");
        String billingZipValue = eleBillingZip.getAttribute("value");
        String billingStateValue = eleBillingState.getAttribute("value");
        String billingCountryValue = eleBillingCpuntry.getAttribute("value");

        String shippingStreetValue = eleShippingStreet.getText();
        String shippingCityValue = eleShippingCity.getAttribute("value");
        String shippingZipValue = eleShippingZip.getAttribute("value");
        String shippingStateValue = eleShippingState.getAttribute("value");
        String shippingCountryValue = eleShippingCountry.getAttribute("value");

        // Verify that Billing and Shipping values are the same
        Assert.assertEquals(billingStreetValue, shippingStreetValue, "Street does not match!");
        Assert.assertEquals(billingCityValue, shippingCityValue, "City does not match!");
        Assert.assertEquals(billingZipValue, shippingZipValue, "Zip/Postal Code does not match!");
        Assert.assertEquals(billingStateValue, shippingStateValue, "State/Province does not match!");
        Assert.assertEquals(billingCountryValue, shippingCountryValue, "Country does not match!");
    
        
		//Step 9. Enter the SLA Expiration Date as Current Date + 20 days
        //Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 20);
        String newDate = dateFormat.format(cal.getTime());
        driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::input[1]")).sendKeys(newDate);
        
		//Step 10. Click on Save button.
        driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
        
		//Step 11. Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
         

        List<WebElement> elements = driver.findElements(By.xpath("//h2[text()='Recent Items']//following::div[@class='mruItem']//span")); 
        boolean isTextPresent = false;

        for (WebElement element : elements) {
        	
            String elementText = element.getText();
            System.out.println("Recent Items Account Text: " + elementText); 

            if (elementText.contains(accountName)) {
            	
                isTextPresent = true;
                break; 
            }
        }
		//Step 12. Navigate to Accounts tab and Verify the newly Created account is displayed
        driver.findElement(By.xpath("//a[text()='Accounts']")).click();
        List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='pbBody']//tbody//tr//th/a")); 
        boolean isTextPresent1 = false;

        for (WebElement element : elements1) {
        	
            String elementText = element.getText();
            System.out.println("Newly Created Account Text in Accounts Tab : " + elementText); 

            if (elementText.contains(accountName)) {
            	
                isTextPresent1 = true;
                break; 
            }
        }
 
    	
		//Step 13. Close the browser 
        driver.close();


		
	}
}
