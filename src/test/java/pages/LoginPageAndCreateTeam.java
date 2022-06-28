package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GenericMethod;
import utilities.randomEmail;
import utilities.randomPassword;
import utilities.randomString;

public class LoginPageAndCreateTeam {

	WebDriver driver;
	GenericMethod wt;
	String baseUrl = "https://app.gohighlevel.com";
	randomPassword randPass = null;
	randomString randString = null;
	randomEmail randEmail;
	randomPassword randSentence = null;

	public LoginPageAndCreateTeam(WebDriver driver) {
		this.driver = driver;
	}

	By emailField = By.id("email");
	By passwordField = By.id("password");
	By signInButton = By.xpath("//button[normalize-space()='Sign in']");

	// >>>>>>>>> ---- Team Management ----- <<<<<<<<<

	By settingLink = By.xpath("//span[normalize-space()='Settings']");

	By myStaff = By.id("sb_my-staff");
	By cancelButton = By.xpath("(//button[@type='button'][normalize-space()='Cancel'])[2]");
	By addEmployeeButton = By.xpath("//button[contains(text(), 'Add Employee')]");
	By teamManagement = By.xpath("//h2[contains(text(), 'Team Management')]");
	By userInfo = By.xpath("//span[contains(text(), 'User Info')]");
	By userPermission= By.xpath("//span[contains(text(), ' User Permissions ')]");
	By userRoles= By.xpath("//button[@data-target='#collapse-user-roles']");
	By callVoicemailSettings= By.xpath("//span[contains(text(), ' Call & Voicemail Settings ')]");
	By userAvailability = By.xpath("//span[contains(text(), ' User Availability ')]");

	// >>---------- user info --------------<<
	By profilePhotoChange = By.id("profileChangePhoto");
	By removePhoto = By.xpath("//button[contains(text(), 'Remove')]");

	By firstName = By.xpath("//input[contains(@placeholder,'First Name')]");
	By lastName = By.xpath("//input[@placeholder='Last Name']");
	By email = By.xpath("//input[@placeholder='Email']");
	By phone = By.xpath("//input[@placeholder='Phone']");
	By extension = By.xpath("//input[@placeholder='Extension']");
	By password = By.xpath("//input[@placeholder='Password']");
	By eSigCheckbox = By.xpath("//input[@id='autofill-signature']");
	By eSigReplyCheckbox = By.xpath("//input[@id='reply-signature']");

	By sentenceType = By.id("tiny-vue_96045223721655999504281_ifr");

	// >>---------- user roles --------------<<
	By userRolesOptions = By.xpath("//button[@data-target='#collapse-user-roles']");

	By saveButton = By.xpath("(//button[contains(@type,'button')][normalize-space()='Save'])[2]");

	// >> ----------- My Team tab ----------- <<<<<<<

	By temsTab = By.xpath("//span[contains (text(), 'Teams')]");
	By addTeamButton = By.xpath("//button[contains(text(), 'Add Team')]");

	By teamInfo = By.xpath("//button[contains(@data-target,'#collapse-team-info')]");
	By firstEmp = By.xpath("(//input[@class = 'focus:ring-curious-blue-500 h-5 w-5 text-curious-blue-600 border-gray-300 rounded mr-2 disabled:opacity-50'])[2]");
	By secondEmp = By.xpath("(//input[@class = 'focus:ring-curious-blue-500 h-5 w-5 text-curious-blue-600 border-gray-300 rounded mr-2 disabled:opacity-50'])[4]");
	By thirdEmp = By.xpath("(//input[@class = 'focus:ring-curious-blue-500 h-5 w-5 text-curious-blue-600 border-gray-300 rounded mr-2 disabled:opacity-50'])[6]");
	By calendarTeamConfig = By.xpath("//button[contains(@data-target,'#collapse-calendarConfiguration-info')]");


	//>>>> ---------Team info---------------<<<<
	By teamNameInput = By.xpath("//input[@placeholder='Add Team Name']");
	By firstTeam = By.xpath("//input[@id='SV1aFs1TvefqANAG99XL']");
	By secondTeam = By.xpath("//input[@id='ZeFopujMKoX4B8YRAy0s']");
	By thirdTeam = By.xpath("//input[@id='tJHjXE9o2cbWZhwhF1md']");

	//>>>> ---------calendar Team Config---------------<<<<
	By addNameInput = By.xpath("//input[@placeholder='Add Name']");
	By addDescription = By.xpath("//textarea[@placeholder='Add Description']");
	By uniqueSlugInput = By.xpath("//input[@placeholder='Enter Unique Slug']");
	By slugUniqueIcon = By.xpath("//div[@class='slug-unique tick-icon']");

	By myTeamSaveButton = By.xpath("(//button[contains(text(), 'Save')])[2]");

	// >>>>> ------- Calendars --------- <<<<<<<
	By calendars = By.xpath("//span[contains(text(), 'Calendars')]");
	By newcalendarLink = By.xpath("(//span[contains(text(),'New Calendar')])[2]");
	By appointmentDistribution = By.xpath("//div[normalize-space()='Appointment Distribution']");
	By optimizeForAvailability = By.xpath("//label[@for='Optimiz_for_Availability']");
	By optimizeForEqualDistribution = By.xpath("//label[@for='Optimiz_for_Equal_Distribution']");
	By priorityDropDown = By.xpath("(//div[@class='priority mr-2 low'])[1]");
	By highPriority = By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='High Priority']");
	By mediumPriority = By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='Medium Priority']");
	By meetingLocation = By.xpath("(//input[@placeholder='Meeting Location'])[1]");
	By addCalendarName = By.xpath("//input[@placeholder='Add Calendar Name']");
	By calendarDescription = By.xpath("//textarea[@placeholder='Add Calendar Description']");
	By calendarSlug = By.xpath("//input[@placeholder='Enter Calendar Slug']");
	By saveCalendarButton = By.xpath("//button[@id='cmp-calmodal__button--save']");

	By appointmentSlotSetting = By.xpath("//div[contains(text(), 'Appointment Slot Settings')]");

	By slotDuration = By.xpath("//*[@id=\"app\"]/div[3]/section/div/div[2]/div/div/div/form/div[2]/div[2]/div[2]/section[1]/div[3]/div[1]/div/div/button");
	By slotInterval = By.xpath("//*[@id=\"app\"]/div[3]/section/div/div[2]/div/div/div/form/div[2]/div[2]/div[2]/section[1]/div[3]/div[2]/div/div/button");
	By slotDuration1Hr = By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='1 hour']");
	By slotInterval45Min = By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='45 minutes']");
	By bufferDuration = By.xpath("//input[@placeholder='Duration in Minutes']");
	By appointmentPerDay = By.xpath("//input[@name='appoinmentPerDay']");

	By minimumSchedulingNotice = By.xpath("(//input[@placeholder='Duration'])[1]");
	By schedulingNoticeType = By.xpath("//*[@id=\"app\"]/div[3]/section/div/div[2]/div/div/div/form/div[2]/div[2]/div[2]/section[2]/div[3]/div[1]/div/div/div/button");
	By schedulingNoticeDay = By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='Weeks']");
	By dateRange = By.xpath("(//input[@placeholder='Duration'])[2]");
	By dateRangeType = By.xpath("//*[@id=\"app\"]/div[3]/section/div/div[2]/div/div/div/form/div[2]/div[2]/div[2]/section[2]/div[3]/div[2]/div/div/div/button");
	By dateRangeDay = By.xpath("//div[@aria-expanded='true']//span[@class='text'][normalize-space()='Weeks']");


	public void setUp() {
		//		ChromeOptions options = new ChromeOptions();
		//		options.addArguments("--disable-notifications");

		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		//		WebDriverManager.chromedriver().setup();
		//		driver = new ChromeDriver(options);
		driver = new FirefoxDriver(options);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void loginToHighLevel() {
		wt = new GenericMethod(driver);

		driver.get(baseUrl);

		driver.findElement(emailField).sendKeys("nishantranjan78@gmail.com");
		driver.findElement(passwordField).sendKeys("Test@123");
		driver.findElement(signInButton).click();

		wt.waitForElement(By.xpath("//img[@class='object-contain agency-logo']"), Duration.ofSeconds(20));
	}

	public void addEmployee() {
		driver.findElement(settingLink).click();
		driver.findElement(myStaff).click();
		driver.findElement(addEmployeeButton).click();
		driver.findElement(cancelButton).click();
		driver.findElement(addEmployeeButton).click();
		driver.findElement(userInfo).click();
		driver.findElement(firstName).sendKeys(randString.randString());
		driver.findElement(lastName).sendKeys(randString.randString());
		driver.findElement(email).sendKeys(randomEmail.randomEmailGenerator());

		driver.findElement(password).sendKeys(randPass.generateRandomPassword(15));
	}

	public void scrollToSaveEmployee() {
		WebElement userR = driver.findElement(By.xpath("//button[@data-target='#collapse-user-roles']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", userR );
		driver.findElement(userRoles).click();

		WebElement saveB =  driver.findElement(By.xpath("(//button[contains(@type,'button')][normalize-space()='Save'])[2]"));

		je.executeScript("arguments[0].scrollIntoView(true)", saveB );
		saveB.click();
		wt.waitForElement(By.xpath("//span[normalize-space()='Team Management']"), Duration.ofSeconds(5));
	}

	public void createTeam() throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		wt.clickWhenReady(By.xpath("//span[contains (text(), 'Teams')]"), Duration.ofSeconds(20));

		driver.findElement(addTeamButton).click();
		driver.findElement(teamInfo).click();

		driver.findElement(teamNameInput).sendKeys(randString.randString());

		driver.findElement(firstEmp).click();
		driver.findElement(secondEmp).click();
		driver.findElement(thirdEmp).click();

		WebElement calendarConfig = driver.findElement(By.xpath("//span[normalize-space()='Calendar Team Configuration']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", calendarConfig);

		driver.findElement(calendarTeamConfig).click();

		driver.findElement(addNameInput).sendKeys(randString.randString());
		driver.findElement(addDescription).sendKeys(randSentence.generateRandomPassword(20));
		driver.findElement(uniqueSlugInput).sendKeys(randString.randString());

		WebElement assignContact = driver.findElement(By.xpath("//button[@id='tgl-allow-assign-contact']"));
		assignContact.click();

		WebElement skipAssign = driver.findElement(By.xpath("//button[@id='tgl-skip-assign-for-existing-contact']"));
		skipAssign.click();

		assignContact.click();

		wt.waitForElement(By.xpath("//div[@class='slug-unique tick-icon']"), Duration.ofSeconds(10));
	}

	public void scrollToSaveTeam() {

		WebElement saveTeamButton = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Save'])[2]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", saveTeamButton );

		saveTeamButton.click();

		wt.waitForElement(By.xpath("//img[@class='object-contain agency-logo']"), Duration.ofSeconds(20));
	}

	public void createCalendarSetUp() {
		driver.get(driver.getCurrentUrl());
		wt.clickWhenReady(By.xpath("//a[@id='sb_calendar']"), Duration.ofSeconds(20));
		driver.findElement(newcalendarLink).click();
		wt.waitForElement(By.xpath("//div[normalize-space()='Appointment Distribution']"), Duration.ofSeconds(10));
		driver.findElement(optimizeForEqualDistribution).click();
		driver.findElement(optimizeForAvailability).click();

		driver.findElement(priorityDropDown).click();
		driver.findElement(highPriority).click();

		driver.findElement(meetingLocation).sendKeys(randString.randString());
		driver.findElement(addCalendarName).sendKeys(randString.randString());
		driver.findElement(calendarSlug).sendKeys(randSentence.generateRandomPassword(8));
		driver.findElement(addCalendarName).sendKeys(randSentence.generateRandomPassword(8));
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();

		wt.waitForElement(By.xpath("//div[@class='slug-unique tick-icon']"), Duration.ofSeconds(10));
	}

	public void scrollToSaveCalendarSetup() {
		WebElement saveCalendarB = driver.findElement(By.xpath("//button[@id='cmp-calmodal__button--save']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", saveCalendarB );
		saveCalendarB.click();
	}


	public void setUpAvailability() {
		wt.waitForElement(appointmentSlotSetting, Duration.ofSeconds(5));

		driver.findElement(slotDuration).click();
		driver.findElement(slotDuration1Hr).click();

		driver.findElement(slotInterval).click();
		driver.findElement(slotInterval45Min).click();
		driver.findElement(bufferDuration).clear();
		driver.findElement(bufferDuration).sendKeys("15");
		driver.findElement(appointmentPerDay).clear();
		driver.findElement(appointmentPerDay).sendKeys("4");

		driver.findElement(minimumSchedulingNotice).clear();
		driver.findElement(minimumSchedulingNotice).sendKeys("10");
		driver.findElement(schedulingNoticeType).click();
		driver.findElement(schedulingNoticeDay).click();

		driver.findElement(dateRange).clear();
		driver.findElement(dateRange).sendKeys("5");
		driver.findElement(dateRangeType).click();
		driver.findElement(dateRangeDay).click();
	}

	public void scrollToSaveAvailability() {
		WebElement saveAvailability = driver.findElement(By.xpath("//button[@id='cmp-calmodal__button--save']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", saveAvailability );
		saveAvailability.click();
	}

	public void scrollToComplete() {
		wt.waitForElement(By.xpath("//div[normalize-space()='Form Settings']"), Duration.ofSeconds(5));

		WebElement completeSetup = driver.findElement(By.xpath("//button[@id='cmp-calmodal__button--save']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", completeSetup );
		completeSetup.click();
		wt.waitForElement(By.xpath("//label[@class='mb-0 mr-2 title']"), Duration.ofSeconds(10));
	}

	public void bookAppointment() {

	}



}
