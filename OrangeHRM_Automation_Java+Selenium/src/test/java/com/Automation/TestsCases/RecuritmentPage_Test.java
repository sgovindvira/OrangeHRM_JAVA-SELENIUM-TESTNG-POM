package com.Automation.TestsCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Automatio.Pages.Adding_Candidates_Page;
import com.Automatio.Pages.HomePage;
import com.Automatio.Pages.LoginPage;
import com.Automatio.Pages.Recruitment_Page;
import com.autonation.base.TestBase;

public class RecuritmentPage_Test extends TestBase{


	HomePage  hp;
	Recruitment_Page recruitment;
	LoginPage lp;
	Adding_Candidates_Page acp;

	@BeforeMethod
	public void setupForRecruitment() throws IOException {
		readConfigFile();
		intialization();
		hp = new HomePage();	
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		recruitment = hp.clickingRecuitment();


	}
	@Test(priority =1)
	public void verifyingRecrutmentPage() {
		AssertJUnit.assertTrue(recruitment.verifyingRecrutitmentPage());
	}


	@Test(priority =2)
	public void clickingVacancies() throws InterruptedException {
		recruitment.clickingVacanicies();
	}

	@Test(priority =3)
	public void clickingAddCandidate() throws InterruptedException {
	 acp   =	recruitment.clickAddButton();

		Thread.sleep(2000);
	}

	
	
	

	

		@AfterMethod
	public void teardwon() {
		teardownTestBase();
		
		
	}

}
