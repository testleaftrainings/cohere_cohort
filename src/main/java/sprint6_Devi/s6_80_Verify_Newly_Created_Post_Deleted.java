package sprint6_Devi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class s6_80_Verify_Newly_Created_Post_Deleted {
	@Test
	public void deleteNewlyCreatedPost() {
		ChromeDriver driver = new ChromeDriver();
		//Step 1: 1. Navigate to Salesforce login page
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Step 2 Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		//Step 3. Click on the 'File'
		driver.findElement(By.xpath("//span[text()='File']")).click();
		
		//Step 4. Click on 'Select a file from Salesforce'
		//Step 5. Click on 'Owned by Me'
		//Step 6. Search for 'Maven'
		//Step 7. Click on the 'Attach' for Maven file
		//Step 8. Click on the 'Share' Button
		//Step 9. Click on the 'More Actions'
		//Step 10. Click on the 'File Sharing Settings'
		//Step 11. Change permissions as 'Collaborators'
		//Step 12. Enable the checkBox for 'Prevent others from sharing and unsharing'
		//Step 13. Verify the checkbox is Enabled
		//Step 14. Click on the 'Close' button.
		//Step 15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
		//Step 16. Verify the Topics as 'Maven Installtion Guide'
		//Step 17. Click on the widget dropdown for post and click 'Delete'
		//Step 18. Click on the 'Ok' Button.
		//Step 19. Verify the post is Deleted.
	
}
}