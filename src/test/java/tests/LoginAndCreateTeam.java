package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPageAndCreateTeam;
import pages.myTeamPage;

public class LoginAndCreateTeam {

	WebDriver driver;

	@Test
	public void test1() throws InterruptedException {
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
	
//	@Test
//	public void test2() {
//		myTeamPage tm = new myTeamPage(driver);
//		tm.createTeam();
//	}

}
