package utilities;

import org.openqa.selenium.WebDriver;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class PageScreenshot {
	
	public static void TakeFullScreenshot(WebDriver driver) throws InterruptedException {
		
		//It will create a folder called scrrenshot to store the evidence.
		//We can pass path as parameter in save method.
		
		Shutterbug.shootPage(driver).save();
	}
	
	
	
}