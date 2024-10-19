package jiraSaleforceAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;



public class CreateContact extends BaseClass  {
	public CreateContact(WebDriver driver) {
		this.driver= driver;
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	public void elementToBeClickable(String input,boolean cl ) {
		WebElement click = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(input))));

		if (cl) {
			click.click();
		}else {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",click);
		}

	}
	public void elementToBeSendKeys(String input,String value) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(input)))).sendKeys(value);
	}

	public  void s6_019_Create_Contact() throws InterruptedException {


		//		Click on Global Actions SVG icon.
		elementToBeClickable("//input[@title='Search Setup']//following::li[2]//a",false);

	
		//		After clicking Global Actions SVG icon, Click 'New Contact'.
		elementToBeClickable("//span[text()='New Contact']",true);


		//		Pick Salutation as 'Mr.'

		elementToBeClickable("//span[text()='Name']//following::a[1]",true);
		elementToBeClickable("//span[text()='Name']//following::a[@title='Mr.']",true);

		Faker fake = new Faker();
		
		//		Enter First Name as 'Naveen'
		String name = fake.name().firstName();
//		String name="Naveen";
		elementToBeSendKeys("//span[text()='Name']//following::input[1]", name);

		//		Enter Last Name as 'Elumalai'
		String lastName = fake.name().lastName();
//		String lastName="Elumalai";
		elementToBeSendKeys("//span[text()='Name']//following::input[2]", lastName);

		//		Enter email as 'naveen@test.com'
		
		elementToBeSendKeys("//span[text()='Name']//following::input[3]", "naveen@test.com");

		//		Create a New Account for Account Name
		WebElement newAccount = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Name']//following::input[6]"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",newAccount);
		elementToBeClickable("//span[text()='Name']//following::input[5]",true);
		elementToBeClickable("//span[text()='Name']//following::span[@title='New Account']",true);

		//		Enter account name as 'Credits' and save

		elementToBeSendKeys("//span[text()='Account Name']//following::input[3]", "Credits");
		elementToBeClickable("//span[text()='Account Information']//following::input[6]//following::button[2]",true);

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))));
		//		Click and save
		elementToBeClickable("//span[text()='Start of Dialog']//following::input[6]//following::button",true);

		//		Verify contact using Unique name and print the name

		WebElement toast = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))));
		org.testng.Assert.assertEquals("Contact \"" + name + " " + lastName + "\" was created.", toast.getText());
		System.out.println(toast.getText());
	
	}
}
