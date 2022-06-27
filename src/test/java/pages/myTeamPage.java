package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.GenericMethod;
import utilities.randomEmail;
import utilities.randomPassword;
import utilities.randomString;

public class myTeamPage {

	WebDriver driver;
	GenericMethod wt;
	randomString randString = null;
	randomEmail randEmail;
	randomPassword randPass = null;

	public myTeamPage(WebDriver driver) {
		this.driver = driver;
	}

	By temsTab = By.xpath("//span[contains (text(), 'Teams')]");
	By addTeamButton = By.xpath("//button[contains(text(), 'Add Team')]");

	By teamInfo = By.xpath("//button[contains(@data-target,'#collapse-team-info')]");
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

	By saveButton = By.xpath("(//button[contains(text(), 'Save')])[2]");

	public void createTeam() {
		
		driver.findElement(temsTab).click();

	}

}
