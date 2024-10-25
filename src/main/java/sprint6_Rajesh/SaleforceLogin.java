package sprint6_Rajesh;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.time.Duration;


public class SaleforceLogin extends BaseClass{

	public SaleforceLogin(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	public void saleForceLogin(String userid,String pass) {
		

		//Step 1: Login to Login | Salesforce 
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys(userid);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("Login")).click();		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

	}

}
