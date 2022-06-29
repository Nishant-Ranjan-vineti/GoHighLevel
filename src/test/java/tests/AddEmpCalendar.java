package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPageAndCreateTeam;


@Listeners (listeners.TestNGListener.class)
public class AddEmpCalendar {

	WebDriver driver;

	@Test
	public void EndToEnd() throws InterruptedException {
		LoginPageAndCreateTeam dr = new LoginPageAndCreateTeam(driver);
		dr.setUp();
		dr.loginToHighLevel();
		dr.addEmployee();
		dr.scrollToSaveEmployee();
		dr.createTeam();
		dr.scrollToSaveTeam();
		dr.createCalendarSetUp();
		dr.scrollToSaveCalendarSetup();
		dr.setUpAvailability();
		dr.scrollToSaveAvailability();
		dr.scrollToComplete();
	}

}
