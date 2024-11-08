package sprint6_Gokul;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bouncycastle.util.Exceptions;
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
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li//a//span[text()='File']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.linkText("Select a file from Salesforce")).click();
//		driver.findElement(By.xpath("//span[text()='Owned by Me']")).click();
		Set<String>  s = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		for(String s1:s)
		{
			System.out.println(s1);
			li.add(s1);
		}
		driver.switchTo().window(li.get(1));
		driver.findElement(By.xpath("//li//a//span[text()='Owned by Me']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search Files I Own...']")).sendKeys("Maven");
		driver.findElement(By.linkText("Search")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Attach']")).click();
		driver.switchTo().window(li.get(0));
		Thread.sleep(2000);
		driver.findElement(By.id("publishersharebutton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='More Actions']")).click();
		driver.findElement(By.xpath("//span[text()='File Sharing Settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td//a//span[@class='permissionLabel']//following::img")).click();
		try
		{
			driver.findElement(By.xpath("//span[@class='permissionLabel' and text()='Collaborators']")).click();
		}
		catch(Exception e)
		{
			System.out.println("Catch block");
//			driver.findElement(By.xpath("//span[@class='permissionLabel' and text()='Viewers']")).click();
		}
		
		try
		{
		Boolean chkbox=driver.findElement(By.xpath("//input[@id='sharingOption' and @value='R']")).isEnabled();
		System.out.println(chkbox);
		}
		catch(Exception e)
		{
		
		driver.findElement(By.id("sharingOption")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Click to add topics:")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[text()='Add your own topics or choose from our suggestions.']")).sendKeys("Maven Installtion Guide");
		driver.findElement(By.xpath("//input[@title='Done']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span//a[@title=\"More Actions\"]")).click();
		
		driver.findElement(By.xpath("//li//a[text()='Delete']")).click();
		Thread.sleep(1000);
		Set<String>  se = driver.getWindowHandles();
		List<String> lis = new ArrayList<String>();
		for(String se1:se)
		{
			System.out.println(se1);
			lis.add(se1);
		}
		driver.switchTo().window(lis.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div//input[@value='OK']")).click();
	}

}
