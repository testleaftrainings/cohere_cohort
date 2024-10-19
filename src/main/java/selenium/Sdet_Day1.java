package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Sdet_Day1 {
	 public static void main(String[] args) {
		// WebDriverManager.chromedriver().setup(); Not required due to latest version
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 
}
}
