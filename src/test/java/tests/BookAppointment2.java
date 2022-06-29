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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.GenericMethod;
import utilities.randCharcter;
import utilities.randomEmail;
import utilities.randomPassword;
import utilities.randomPhone;
import utilities.randomString;

@Listeners (listeners.TestNGListener.class)
public class BookAppointment2 {

	WebDriver driver;
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
	String calendars = "//span[@class='hl_text-overflow hidden md:hidden nav-title lg:block xl:block'][normalize-space()='Calendars']";
	String bookAppointment = "//button[@id='pg-appt__btn--appt-add']";
	String bookAppointmentModal = "//div[contains(text(), 'Book Appointment')]";
	String contact = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div[2]/div[2]/div[2]";
	String availableContact = "(//div[@class='ml-1'])[1]";
	String timezone = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div/span/a[1]/div";
	String appointmentTitle = "//input[@placeholder = '(eg) Appointment with Bob']";
	String bookAppointmentButton = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/button";
	String appointmentsTab = "//span[normalize-space()='Appointments']";
	String lastAppointments = "//tbody/tr[1]/td[1]";
	String appointmentTime = "//*[@id=\"calendarEvents\"]/div/div[3]/div/div/table/tbody/tr[1]/td[3]/div";


	@Test
	public void test1() throws InterruptedException {

		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);

		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wt = new GenericMethod(driver);

		driver.get(baseUrl);

		driver.findElement(By.id(emailField)).sendKeys("nishantranjan78@gmail.com");
		driver.findElement(By.id(passwordField)).sendKeys("Test@123");
		driver.findElement(By.xpath(signInButton)).click();

		wt.waitForElement(By.xpath(logo), Duration.ofSeconds(20));

		driver.findElement(By.xpath(calendars)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(bookAppointment)).click();

		driver.switchTo().frame("calendar-app");

		wt.waitForElement(By.xpath(bookAppointmentModal), Duration.ofSeconds(5));

		WebElement el =  driver.findElement(By.xpath(bookAppointmentModal));
		System.out.println(el.getText());

		WebElement clickTeam = driver.findElement(By.xpath(availableContact));
		clickTeam.click();
		wt.waitForElement(By.xpath(contact), Duration.ofSeconds(20));
		
		
		WebElement timezoneDropdown = driver.findElement(By.xpath("(//*[@id=\"options-menu\"])[2]"));
		timezoneDropdown.click();
		
		WebElement input = driver.findElement(By.xpath("//*[@id=\"uidropdown-input-search\"]"));
		input.sendKeys(randCharcter.randChar());
		
		driver.findElement(By.xpath(timezone)).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(appointmentTitle)).sendKeys(randString.randString());
		Thread.sleep(2000);
		driver.findElement(By.xpath(bookAppointmentButton)).click();
	}

}
