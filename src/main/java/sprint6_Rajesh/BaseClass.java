package sprint6_Rajesh;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
	public RemoteWebDriver driver = null;


	public void browserInitiate(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-save-password-bubble");
			chromeOptions.addArguments("--disable-autofill-keyboard-accessory-view[8]");
			chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			driver = new ChromeDriver(chromeOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications");
			driver = new EdgeDriver(edgeOptions);
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-notifications");
			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
	}

	public void gridExecution(String browser) throws MalformedURLException {

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); 
			options.setPlatformName("LINUX"); 

			DesiredCapabilities ChromeDC = new DesiredCapabilities();
			ChromeDC.setBrowserName("chrome");
			ChromeDC.setPlatform(Platform.LINUX);
			ChromeDC.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), ChromeDC);
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications"); 
			edgeOptions.setPlatformName("LINUX"); 
			DesiredCapabilities edgeDC = new DesiredCapabilities();
			edgeDC.setBrowserName("MicrosoftEdge");
			edgeDC.setPlatform(Platform.LINUX);
			edgeDC.setCapability(ChromeOptions.CAPABILITY, edgeOptions);

			driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), edgeDC);
			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("dom.webnotifications.enabled", false);
			firefoxOptions.setPlatformName("LINUX");
			DesiredCapabilities firefoxDC = new DesiredCapabilities();
			firefoxDC.setBrowserName("firefox");
			firefoxDC.setPlatform(Platform.LINUX);
			firefoxDC.setCapability(ChromeOptions.CAPABILITY, firefoxDC);
			driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), firefoxDC);
			break;

		default:
			throw new IllegalArgumentException("Browser not supported: " + browser);

		}


	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
