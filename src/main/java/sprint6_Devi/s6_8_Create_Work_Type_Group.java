package selenium;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	public class Create_WorkType {
	@Test
	public void workType() {
		ChromeDriver driver = new ChromeDriver();
		//Step 1: Launch the salesforce app
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		//Step 2: Login with the credentials
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		//Step 3: Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Step 4: Click view All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();	
		WebElement eleWorkType = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].click();", eleWorkType);
		
		//Step 5: Click on New Work Type Group
		WebElement eleWorkTypeGroup = driver.findElement(By.xpath("(//span[text()='Work Type Groups']//following::div[1]//a)[1]"));
		eleWorkTypeGroup.click();
		//driver.executeScript("arguments[0].click();", eleWorkTypeGroup);
		
		WebElement eleNewWorkTypeGroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click();", eleNewWorkTypeGroup);
		
		//Step 6: Enter Description as 'Automation'.
		driver.findElement(By.xpath("//label[text()='Description']//following::textarea")).sendKeys("Automation");
		
		//Step 7: .Select Group Type as 'Capacity'
		driver.findElement(By.xpath("//label[text()='Group Type']//following::button[1]")).click();
		WebElement eleGroupType = driver.findElement(By.xpath("//label[text()='Group Type']//following::button[1]//following::span[text()='Capacity']"));
		eleGroupType.click();
		//driver.executeScript("arguments[0].click();", eleGroupType);
		
		//Step 8:  Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//Step 9:  Verify the Alert message (Complete this field) displayed for Work Type Group Name
		driver.findElement(By.xpath("//div[@role='dialog']//a[text()='Work Type Group Name']")).click();
		String errorMessage= driver.findElement(By.xpath("//div[text()='Complete this field.']")).getText();
		errorMessage.equals("Complete this field.");
}
	}
