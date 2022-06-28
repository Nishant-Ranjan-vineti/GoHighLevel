package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import utilities.GenericMethod;
import utilities.randomEmail;
import utilities.randomPassword;
import utilities.randomPhone;
import utilities.randomString;

public class quickTest2 {
	
	WebDriver driver;
	GenericMethod wt;
	String baseUrl = "https://app.gohighlevel.com";
	randomString randString = null;
	randomEmail randEmail;
	randomPhone phone = null;
	randomPassword randPass = null;
	randomPassword randSentence = null;
	
	@Test
	public void test1() throws InterruptedException {
		
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);

		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wt = new GenericMethod(driver);

		driver.get(baseUrl);

		driver.findElement(By.id("email")).sendKeys("nishantranjan78@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

		wt.waitForElement(By.xpath("//img[@class='object-contain agency-logo']"), Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//span[@class='hl_text-overflow hidden md:hidden nav-title lg:block xl:block'][normalize-space()='Calendars']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Appointments']")).click();
		
		wt.waitForElement(By.xpath("//tbody/tr[1]/td[1]"), Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//*[@id=\"calendarEvents\"]/div/div[3]/div/div/table/tbody/tr[1]/td[3]/div"));
		
	}

}
