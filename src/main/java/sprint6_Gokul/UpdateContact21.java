package sprint6_Gokul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateContact21 {
	ChromeDriver driver = new ChromeDriver();

	@Test
	public void editOppMethod() throws InterruptedException {

		SoftAssert sAssert = new SoftAssert();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		WebElement opp = driver.findElement(By.xpath("//span/p[text()='Contacts']"));
		Actions action = new Actions(driver);
		action.moveToElement(opp).perform();
		opp.click();
		Thread.sleep(5000);
		String str = driver.findElement(By.xpath("//span[@aria-label=\"Recently Viewed\"]")).getText();
		String[] str1 = str.split("\\s");
		System.out.println(str1[0]);
		String str2 = str1[0];
		int count = Integer.parseInt(str2);
		System.out.println(count);
		List<String> conName = new ArrayList<String>();

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		int counts = 0;

		Thread.sleep(5000);
		String count1 = driver.findElement(By.xpath("//span[@role='status']")).getText();
		String[] strs = count1.split("\\s");
		int countNum = Integer.parseInt(strs[0]);
		System.out.println(countNum);
		int size1 = driver.findElements((By.xpath("//th[@data-aura-class=\"forceInlineEditCell\"]//a"))).size();
		System.out.println(size1);
		List<WebElement> names;
		while (size1 != countNum) {
			size1 = driver.findElements((By.xpath("//th[@data-aura-class=\"forceInlineEditCell\"]//a"))).size();
			count1 = driver.findElement(By.xpath("//span[@role='status']")).getText();
			strs = count1.split("\\s");

			countNum = Integer.parseInt(strs[0]);
			names = driver.findElements(By.xpath("//th[@data-aura-class=\"forceInlineEditCell\"]//a"));
			for (WebElement numlist : names) {

				action.moveToElement(numlist).perform();
				System.out.println(numlist.getText());
				count1 = driver.findElement(By.xpath("//span[@role='status']")).getText();
				strs = count1.split("\\s");

				countNum = Integer.parseInt(strs[0]);

			}
		}
		names = driver.findElements(By.xpath("//th[@data-aura-class=\"forceInlineEditCell\"]//a"));
		for (WebElement name : names) {
			String txt = name.getText();
			txt = txt.toLowerCase();
			System.out.println(txt);

			for (int i = 0; i < 1; i++) {
				if (hmap.containsKey(txt)) {
					counts = hmap.get(txt);
					hmap.put(txt, ++counts);
				} else {
					hmap.put(txt, 1);

				}
			}

		}

		System.out.println(hmap);

		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			if (entry.getValue().equals(1)) {
				String name1 = entry.getKey();
				conName.add(name1);
				System.out.println(name1);
			}

		}

		String[] stringArray = conName.toArray(new String[0]);
		String passName = "";
		for (String s : stringArray) {
			System.out.println(s);
			passName = s;
		}
		driver.findElement(By.xpath("//input[@name=\"Contact-search-input\"]")).sendKeys(passName);

		action.sendKeys(Keys.ENTER).perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@role='gridcell']//a[@role='button']")).click();
		Thread.sleep(5000);
		WebElement edit = driver.findElement(By.xpath("//li//div[@title='Edit']"));
		action.moveToElement(edit).click().perform();
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
		email.clear();
		String eMail = "mgokulakrishnan02@gmail.com";
		email.sendKeys(eMail);

		WebElement leadSource = driver.findElement(By.xpath("//button[@aria-label=\"Lead Source\"]"));
		leadSource.click();
		Thread.sleep(4000);
		WebElement partner = driver
				.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Partner Referral']"));
		Thread.sleep(5000);
		driver.executeScript("arguments[0].click();", partner);

		WebElement street1 = driver.findElement(By.xpath("(//textarea[@autocomplete=\"street-address\"])[1]"));
		street1.clear();
		street1.sendKeys("Gokul Illam");

		WebElement otStreet1 = driver.findElement(By.xpath("(//textarea[@autocomplete=\"street-address\"])[2]"));
		otStreet1.clear();
		otStreet1.sendKeys("Periyar Nagar");

		WebElement des = driver.findElement(By.xpath("//label[text()='Description']"));
		action.moveToElement(des).perform();
		driver.findElement(By.xpath("//button[@aria-label='Level']")).click();

		WebElement teritory = driver
				.findElement(By.xpath("//div/lightning-base-combobox-item//span[@title=\"Tertiary\"]"));
		driver.executeScript("arguments[0].click();", teritory);

		WebElement title = driver.findElement(By.xpath("//input[@name=\"Title\"]"));
		title.clear();
		title.sendKeys("Automation Testing");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		String msg = driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]")).getText();
		System.out.println(msg);
		String emailVali = driver.findElement(By.xpath("(//span[@data-aura-class=\"forceInlineEditCell\"]/a)[2]"))
				.getText();
		System.out.println(emailVali);
		sAssert.assertEquals(eMail, emailVali, "mail is not matching");
//				sAssert.assertEquals("Gokul",emailVali,"mail is not matching");
		sAssert.assertAll();

	}

	@AfterTest
	public void afMethod() {
		driver.quit();
	}

}
