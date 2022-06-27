package tests;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GenericMethod;
import utilities.randomEmail;
import utilities.randomInt;
import utilities.randomPassword;
import utilities.randomPhone;
import utilities.randomString;

public class test2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		GenericMethod wt;
		String baseUrl = "https://app.gohighlevel.com";
		randomString randString = null;
		randomEmail randEmail;
		randomPhone phone = null;
		randomPassword randPass = null;
		randomPassword randSentence = null;



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

		driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
		driver.findElement(By.id("sb_my-staff")).click();
		wt.clickWhenReady(By.xpath("//button[contains(text(), 'Add Employee')]"), Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[@class='modal-buttons d-flex align-items-center justify-content-between']"
				+ "//button[@type='button'][normalize-space()='Cancel']")).click();

		wt.clickWhenReady(By.xpath("//button[contains(text(), 'Add Employee')]"), Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[contains(text(), 'User Info')]")).click();

		driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys(randString.randString());

		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(randString.randString());

		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(randomEmail.randomEmailGenerator());

		WebElement elPhone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(randomPassword.generateRandomPassword(8));

		WebElement userRoles = driver.findElement(By.xpath("//button[@data-target='#collapse-user-roles']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", userRoles );

		userRoles.click();

		WebElement saveButton =  driver.findElement(By.xpath("(//button[contains(@type,'button')][normalize-space()='Save'])[2]"));

		je.executeScript("arguments[0].scrollIntoView(true)", saveButton );
		saveButton.click();

		wt.waitForElement(By.xpath("//img[@class='object-contain agency-logo']"), Duration.ofSeconds(20));

		driver.get(driver.getCurrentUrl());

		wt.clickWhenReady(By.xpath("//span[contains (text(), 'Teams')]"), Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[normalize-space()='Add Team']")).click();
		driver.findElement(By.xpath("//button[contains(@data-target,'#collapse-team-info')]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Add Team Name']")).sendKeys(randString.randString());

		driver.findElement(By.xpath("(//input[@class = 'focus:ring-curious-blue-500 h-5 w-5 text-curious-blue-600 border-gray-300 rounded mr-2 disabled:opacity-50'])[2]")).click();
		driver.findElement(By.xpath("(//input[@class = 'focus:ring-curious-blue-500 h-5 w-5 text-curious-blue-600 border-gray-300 rounded mr-2 disabled:opacity-50'])[4]")).click();
		driver.findElement(By.xpath("(//input[@class = 'focus:ring-curious-blue-500 h-5 w-5 text-curious-blue-600 border-gray-300 rounded mr-2 disabled:opacity-50'])[5]")).click();


		WebElement calendarConfig = driver.findElement(By.xpath("//span[normalize-space()='Calendar Team Configuration']"));
		je.executeScript("arguments[0].scrollIntoView(true)", calendarConfig );

		driver.findElement(By.xpath("//span[normalize-space()='Calendar Team Configuration']")).click();

		driver.findElement(By.xpath("//input[contains(@placeholder,'Add Name')]")).sendKeys(randString.randString());
		driver.findElement(By.xpath("//textarea[@placeholder='Add Description']")).sendKeys(randSentence.generateRandomPassword(20));

		driver.findElement(By.xpath("//input[@placeholder='Enter Unique Slug']")).sendKeys(randString.randString());

		WebElement assignContact = driver.findElement(By.xpath("//button[@id='tgl-allow-assign-contact']"));
		assignContact.click();

		WebElement skipAssign = driver.findElement(By.xpath("//button[@id='tgl-skip-assign-for-existing-contact']"));
		skipAssign.click();

		assignContact.click();

		wt.waitForElement(By.xpath("//div[@class='slug-unique tick-icon']"), Duration.ofSeconds(5));


		WebElement saveTeamButton = driver.findElement(By.xpath("(//button[contains(@type,'button')][normalize-space()='Save'])[2]"));
		je.executeScript("arguments[0].scrollIntoView(true)", saveTeamButton );

		saveTeamButton.click();

		driver.get(driver.getCurrentUrl());

		wt.clickWhenReady(By.xpath("//a[@id='sb_calendar']"), Duration.ofSeconds(20));

		driver.findElement(By.xpath("(//span[contains(text(),'New Calendar')])[3]")).click();

		wt.waitForElement(By.xpath("//div[normalize-space()='Appointment Distribution']"), Duration.ofSeconds(10));

		driver.findElement(By.xpath("//label[@for='Optimiz_for_Equal_Distribution']")).click();
		driver.findElement(By.xpath("//label[@for='Optimiz_for_Availability']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='priority mr-2 low'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='High Priority']")).click();


		driver.findElement(By.xpath("(//input[@placeholder='Meeting Location'])[1]")).sendKeys(randString.randString());
		driver.findElement(By.xpath("//input[@placeholder='Add Calendar Name']")).sendKeys(randString.randString());

		driver.findElement(By.xpath("//textarea[@placeholder='Add Calendar Description']")).sendKeys(randSentence.generateRandomPassword(40));
		driver.findElement(By.xpath("//input[@placeholder='Enter Calendar Slug']")).sendKeys(randSentence.generateRandomPassword(8));
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		
		wt.waitForElement(By.xpath("//div[@class='slug-unique tick-icon']"), Duration.ofSeconds(5));
		WebElement saveCalendarButton = driver.findElement(By.xpath("//button[@id='cmp-calmodal__button--save']"));
		je.executeScript("arguments[0].scrollIntoView(true)", saveCalendarButton );
		saveCalendarButton.click();
		
		wt.waitForElement(By.xpath("//div[contains(text(), 'Appointment Slot Settings')]"), Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select input-medium']//button[@title='30 minutes']")).click();
		driver.findElement(By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='1 hour']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select input-medium pristine untouched valid']//button[@title='30 minutes']")).click();
		driver.findElement(By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='45 minutes']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Duration in Minutes']")).sendKeys("15");
		
		driver.findElement(By.xpath("//input[@name='appoinmentPerDay']")).sendKeys("4");
		
		WebElement saveAvailability = driver.findElement(By.xpath("//button[@id='cmp-calmodal__button--save']"));
		je.executeScript("arguments[0].scrollIntoView(true)", saveAvailability );
		saveAvailability.click();
		
		wt.waitForElement(By.xpath("//div[normalize-space()='Form Settings']"), Duration.ofSeconds(5));
		
		WebElement completeSetup = driver.findElement(By.xpath("//button[@id='cmp-calmodal__button--save']"));
		je.executeScript("arguments[0].scrollIntoView(true)", completeSetup );
		completeSetup.click();
		
		
		
	}


}
