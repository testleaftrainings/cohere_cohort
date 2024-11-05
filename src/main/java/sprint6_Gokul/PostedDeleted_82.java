package sprint6_Gokul;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PostedDeleted_82 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void postedDeletedMethod() throws Exception {

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("AllTab_Tab")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr//td[@class='dataCol fileBlock']//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Owned by Me']")).click();
	}

}
