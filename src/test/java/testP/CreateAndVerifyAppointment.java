package testP;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.GenericMethod;
import utilities.randomEmail;
import utilities.randomPassword;
import utilities.randomString;

public class CreateAndVerifyAppointment {

	WebDriver driver;
	GenericMethod wt;
	String baseUrl = "https://app.gohighlevel.com";
	randomPassword randPass = null;
	randomString randString = null;
	randomEmail randEmail;
	randomPassword randSentence = null;

	public CreateAndVerifyAppointment(WebDriver driver) {
		this.driver = driver;
	}

	By emailField = By.id("email");
	By passwordField = By.id("password");
	By signInButton = By.xpath("//button[normalize-space()='Sign in']");

	By settingLink = By.xpath("//span[normalize-space()='Settings']");
	By calndarLink = By.xpath("//*[@id=\\\"card_view_container\\\"]/div[2]/div/div[2]/div[2]/div/div[4]/button");


	public void bookAppointment() {
		wt = new GenericMethod(driver);

		driver.get(baseUrl);

		driver.findElement(emailField).sendKeys("nishantranjan78@gmail.com");
		driver.findElement(passwordField).sendKeys("Test@123");
		driver.findElement(signInButton).click();

		wt.waitForElement(By.xpath("//img[@class='object-contain agency-logo']"), Duration.ofSeconds(20));

		driver.findElement(settingLink).click();
		wt.clickWhenReady(By.xpath("//a[@id='sb_calendar']"), Duration.ofSeconds(20));

		driver.findElement(calndarLink).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);

		System.out.println("Total window number: " + windowHandlesList.size() + "\n");
		driver.switchTo().window(windowHandlesList.get(1));

		wt.waitForElement(By.xpath("//*[@id=\"appointment_widgets\"]/div/div/div/div[1]/div[1]/h4"), Duration.ofSeconds(20));
	}

}
