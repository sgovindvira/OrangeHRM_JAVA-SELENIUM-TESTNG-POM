package com.Automation.TestsCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Automatio.Pages.HomePage;
import com.Automatio.Pages.LoginPage;
import com.Automatio.Pages.Recruitment_Page;
import com.autonation.base.TestBase;

public class HomePage_Test extends TestBase{



	LoginPage loginpage;
	HomePage homepage;
	Recruitment_Page recruitment;

	@BeforeMethod
	public void setup() throws IOException {


		readConfigFile();
		intialization();
		recruitment = new Recruitment_Page();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test(priority =1)
	public void homepageTitle() {

		String homepagetitle=	homepage.verifyTitleHomepage();
		System.out.println("Actual title is ->> " + homepagetitle);
		Assert.assertEquals(homepagetitle, "OrangeHRM", "HomePage title is not matched");

	}


	@Test(priority =2)
	public void checkingUser()
	{
		String	user =homepage.checkingUser();
		System.out.println("User is " + user);
		AssertJUnit.assertEquals(user, "Paul Collings");
	}
	
	@Test(priority =3)
	public void links() {
		homepage.checkingLinks();
	}
	
	@Test(priority =4)
	public void clickOnRecruitment() throws InterruptedException {
		
	recruitment =	homepage.clickingRecuitment();
	Thread.sleep(4000);
	}



	@AfterMethod
	public void closingBrowser() {
		teardownTestBase();

	}




}
