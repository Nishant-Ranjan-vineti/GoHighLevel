package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.GenericMethod;
import utilities.randCharcter;
import utilities.randomEmail;
import utilities.randomPassword;
import utilities.randomPhone;
import utilities.randomString;

/**
 * @author nishantranjan
 *
 */

@Listeners (listeners.TestNGListener.class)
public class BookAppointmentCloud {
	
	public RemoteWebDriver driver;
    public String username = "*********";
    public String accesskey = "***************";
    public String gridURL = "hub.lambdatest.com";
    public String hub;
	
	//WebDriver driver;
	GenericMethod wt;
	String baseUrl = "https://app.gohighlevel.com";
	randomString randString = null;
	randomEmail randEmail;
	randomPhone phone = null;
	randomPassword randPass = null;
	randomPassword randSentence = null;
	
	
	
	String emailField = "email";
	String passwordField = "password";
	String signInButton = "//button[normalize-space()='Sign in']";
	
	String logo = "//img[@class='object-contain agency-logo']";
	String settingLink = "//span[normalize-space()='Settings']";
	String calendars = "//a[@id='sb_calendar']";
	String teamCalendarLink = "//*[@id=\"card_view_container\"]/div[3]/div/div[2]/div[2]/div/div[4]/button";
	String calendarPage = "//*[@id=\"appointment_widgets\"]/div/div/div/div[1]/div[1]";
	String nextMonthLink = "//button[@title='Next month']";
	String weekCol = "//*[@id=\"appointment_widgets\"]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/table/thead/tr";
	String date = "//*[@id=\"appointment_widgets\"]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/table/tbody/tr[5]/td[5]/div";
	String time = "//*[@id=\"appointment_widgets\"]/div/div/div/div[2]/div/div[2]/ul/li[2]/span";
	String fName = "//input[@id='first_name']";
	String lName = "//input[@id='last_name']";
	String phoneN = "//input[@id='phone']";
	String email = "//input[@placeholder='Email']";
	String desc = "//textarea[@placeholder='Is there anything you would like us to know before your appointment?']";
	String schedule = "//button[@class='btn btn-schedule']";
	String timezone = "//*[@id=\"appointment_widgets\"]/div/div/div/div[2]/div/div[1]/div/div[2]/div/div[3]/ul/li[6]/span/div/span[1]";
	String backButton = "//div[@id='backButtonv2']";
	String calendarsHome = "//span[normalize-space()='Calendars']";
	String appointmentsTab = "//span[normalize-space()='Appointments']";
	String lastAppointments = "//tbody/tr[1]/td[1]";
	String appointmentTime = "//*[@id=\"calendarEvents\"]/div/div[3]/div/div/table/tbody/tr[1]/td[3]/div";
	
	
	@Test
	public void createAndVerifyAppointment() throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", "Demo Suite-" + date);
        
//        caps.setCapability("name", "Test on " + platform );
        
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version","103.0");
        caps.setCapability("network", false);
        caps.setCapability("visual", true);
        caps.setCapability("console", "true");
        caps.setCapability("selenium_version","4.1.2");
        
     // INIT CHROME OPTIONS
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();

        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        
        options.setExperimentalOption("prefs", prefs);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        hub = "https://" + username + ":" + accesskey + "@" + gridURL + "/wd/hub";
        driver = new RemoteWebDriver(new URL(hub), caps);
		
		//Block notification
//		FirefoxOptions options = new FirefoxOptions();
//		options.addPreference("dom.webnotifications.enabled", false);
//
//		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
		wt = new GenericMethod(driver);
		driver.get(baseUrl);

		//login
		driver.findElement(By.id(emailField)).sendKeys("nishantranjan78@gmail.com");
		driver.findElement(By.id(passwordField)).sendKeys("Test@123");
		driver.findElement(By.xpath(signInButton)).click();
		wt.waitForElement(By.xpath(logo), Duration.ofSeconds(40));
		
		//click on calendar
		driver.findElement(By.xpath(settingLink)).click();
		wt.clickWhenReady(By.xpath(calendars), Duration.ofSeconds(20));
		driver.findElement(By.xpath(teamCalendarLink)).click();
		
		//Switch window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		System.out.println("Total window number: " + windowHandlesList.size() + "\n");
		driver.switchTo().window(windowHandlesList.get(1));
		
		wt.waitForElement(By.xpath(calendarPage), Duration.ofSeconds(20));
		driver.findElement(By.xpath(nextMonthLink)).click();
		
		//select time and date
		wt.waitForElement(By.xpath(weekCol), Duration.ofSeconds(10));	
		driver.findElement(By.xpath(time)).click();
		wt.clickWhenReady(By.xpath("//*[@id=\"appointment_widgets\"]/div/div/div/div[2]/div/div[2]/ul/li[2]/span"), Duration.ofSeconds(10));
		
		//select timezone
		WebElement timezoneDropdown = driver.findElement(By.xpath("//div[@class='multiselect__tags']"));
		timezoneDropdown.click();
		WebElement input = driver.findElement(By.xpath("//input[@placeholder='Type here to search timezone']"));
		input.sendKeys(randCharcter.randChar());
		driver.findElement(By.xpath(timezone)).click();
		
		Thread.sleep(3000);
		
		// continue to booking
		WebElement continueTo = driver.findElement(By.xpath("//button[@class='btn btn-schedule']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", continueTo);
		continueTo.click();
		
		driver.findElement(By.xpath(fName)).sendKeys(randString.randString());
		driver.findElement(By.xpath(lName)).sendKeys(randString.randString());
		WebElement ph = driver.findElement(By.xpath(phoneN));
		ph.sendKeys(phone.randPhone());
		
		je.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		
		driver.findElement(By.xpath(email)).sendKeys(randomEmail.randomEmailGenerator());
		driver.findElement(By.xpath(desc))
		.sendKeys(randomPassword.generateRandomPassword(100));
		
		WebElement scheduleMeeting = driver.findElement(By.xpath(schedule));
		scheduleMeeting.click();
		
		//verify appointment
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.findElement(By.xpath(backButton)).click();
		driver.findElement(By.xpath(calendarsHome)).click();
		driver.findElement(By.xpath(appointmentsTab)).click();
		
		wt.waitForElement(By.xpath(lastAppointments), Duration.ofSeconds(10));
		
		driver.findElement(By.xpath(appointmentTime));
		
	}

}
