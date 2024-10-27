package PackHasSingleClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NbaPlayerExp {
	static RemoteWebDriver driver;
	@Test
	public void playerExp() throws InterruptedException, MalformedURLException {
//		DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setBrowserName("MicrosoftEdge");
////		dc.setBrowserName("Chrome");
//        dc.setPlatform(Platform.LINUX);
//        driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.nba.com/stats");
		List<String> lin = new ArrayList<String>();
		List<Integer> lia = new ArrayList<Integer>();
		Map<Integer,String> m = new HashMap<Integer,String>();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//button[text()='I Accept']")).click();
		driver.findElement(By.linkText("See All Player Stats")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label//p[text()='Season']//following::div//select)[1]"));
		driver.findElement(By.xpath("//select//option[text()='2023-24']")).click();
		driver.findElement(By.xpath("(//label//p[text()='Season Type']//following::div//select)[1]"));
		driver.findElement(By.xpath("//select//option[text()='NBA Cup']")).click();
		driver.findElement(By.xpath("(//label//p[text()='Per Mode']//following::div//select)[1]"));
		driver.findElement(By.xpath("//select//option[text()='Per Game']")).click();
		Thread.sleep(5000);

		Thread.sleep(5000);
		try {
		WebElement dialog = driver.findElement(By.xpath("(//div[@role='dialog']//button[@data-click='close']//span)[1]"));
//		action.moveToElement(dialog);
		dialog.click();
		}
		catch(Exception e)
		{
			
		}
		
		List<WebElement> names = driver.findElements(By.xpath("//div//table//tr//th[text()='Player']//following::tr//td//following::td[contains(@class,'Crom_primary')]//a"));
		
		for(WebElement name:names)
		{
			String nm = name.getText();
			System.out.println(nm);
			lin.add(nm);
		}
		
List<WebElement> ages = driver.findElements(By.xpath("//div//table//tr//th[text()='Player']//following::tr//td[contains(@class,'Crom_stickyRank')]//following::td[3]"));
		
		for(WebElement age:ages)
		{
			String ag = age.getText();
			int a = Integer.parseInt(ag);
			System.out.println(ag);
			lia.add(a);
		}
		
		for(int i=0;i<lin.size();i++)
		{
			String n1= lin.get(i);
			int a1=lia.get(i);
			m.put(a1, n1);
		}
		Collections.sort(lia);
		String str=m.get(lia.get(0));
		
		System.out.println(str);
		driver.findElement(By.xpath("//button[@title='Add a custom filter']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Value']")).sendKeys(str);
		driver.findElement(By.linkText(str)).click();
		Thread.sleep(1000);
		WebElement exp =driver.findElement(By.xpath("//div//p[text()='EXPERIENCE']//following::p"));
		String ex=exp.getText();
		SoftAssert sassert = new SoftAssert();
		sassert.assertEquals(ex, "1 Year","Not equal");
		sassert.assertAll();
		driver.quit();
	}

}
