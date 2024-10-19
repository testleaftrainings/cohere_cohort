package sprint6_Rajesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_53_AddProductWithOpportunity extends BaseClass {
	public S6_53_AddProductWithOpportunity(WebDriver driver) {
		this.driver=driver;
	}
	@Test
	public void addProduct() throws InterruptedException {

		//		Click on toggle menu button from the left corner 


		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();


		//		Click view All 

		driver.findElement(By.xpath("//button[@title='Close']//following::button")).click();

		//		Click on Content tab 

		driver.findElement(By.xpath("//button[@title='Close this window']//following::a[5]")).click();


		//		Click View All Key Deals in Key Deals 
		driver.findElement(By.xpath("//div[@data-component-id='home_topDealsContainer']//span[@class='viewAllLabel']")).click();


		//		Click the dropdown from Opportunities and select All Opportunities 


		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[1]")).click();
		driver.findElement(By.xpath("(//a[@role='option']/span)[1]")).click();


		//		Give SRM Steels in Search Box and search 

		String customer ="SRM Steels";
		WebElement searchBox = driver.findElement(By.xpath("//div[@title='New']//following::input[1]"));
		searchBox.sendKeys(customer);
		Thread.sleep(2000);
		//		searchBox.sendKeys(Keys.ENTER);

		WebElement refresh = driver.findElement(By.xpath("//button[@title='Refresh']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", refresh);

		Thread.sleep(2000);
		//		Click on the SRM Steels under Opportunity Name 

		driver.findElement(By.xpath("//a[@title='"+customer+"']")).click();



		//		Click on  dropdown of Products under Related and select Add Products 


		driver.findElement(By.xpath("//span[@title='Products']//following::a[1]")).click();
		driver.findElement(By.xpath("//div[@class='branding-actions actionMenu']//li[1]")).click();


		//		Click on List Price to sort the result and select the highest priced product 


		WebElement sort = driver.findElement(By.xpath("//span[@title='List Price']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sort);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sort);

		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("(//span[@class='slds-truncate forceOutputCurrency'])[1]")).getText();
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.xpath("(//tbody)[2]//input[@type='checkbox']"));

		int width = checkbox.getSize().getWidth();
		int height = checkbox.getSize().getHeight();
		int xCenter = checkbox.getLocation().getX() + width / 2;
		int yCenter = checkbox.getLocation().getY() + height / 2;

		Actions actions = new Actions(driver);
		actions.moveByOffset(xCenter, yCenter).click().perform();

		Thread.sleep(2000);
		//		Click Next and give product Quantity as 560, click Save 
		driver.findElement(By.xpath("//button[@title='Next']")).click();
		Thread.sleep(2000);
		String quantity="560";
		driver.findElement(By.xpath("(//tbody)[2]//following::td[1]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tbody)[2]//following::input")).sendKeys(quantity);
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("((//table)[2]//following::span[@class='slds-truncate'])[2]")).click();
		Thread.sleep(2000);

		quantity = driver.findElement(By.xpath("((//tbody)[2]//following::td[1]//span)[2]")).getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		
		//		Verify the Sales Price and Product Name 

		WebElement verifyQuantity = driver.findElement(By.xpath("//div[@class='slds-tile__detail']//following::span[1]"));
		String verifyQty = verifyQuantity.getText();
		WebElement verifyPrice = driver.findElement(By.xpath("//div[@class='slds-tile__detail']//following::span[2]"));
		String verifypr = verifyPrice.getText();
		
		Assert.assertEquals(quantity, verifyQty);
		Assert.assertEquals(price, verifypr);


	}
}
