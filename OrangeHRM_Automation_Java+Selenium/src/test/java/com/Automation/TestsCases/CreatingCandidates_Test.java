package com.Automation.TestsCases;

import java.io.IOException;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automatio.Pages.Adding_Candidates_Page;
import com.Automatio.Pages.HomePage;
import com.Automatio.Pages.LoginPage;
import com.Automatio.Pages.Recruitment_Page;
import com.automation.util.Test_Util;
import com.autonation.base.TestBase;

public class CreatingCandidates_Test extends TestBase{
	 String Sheetname = "Candidates";
	
	HomePage  hp;
	Recruitment_Page recruitment;
	LoginPage lp;
	Adding_Candidates_Page acp;


	@BeforeMethod
	public void setupCreatingCandidate() throws IOException {
		readConfigFile();
		intialization();
		hp = new HomePage();	
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		recruitment = hp.clickingRecuitment();
		acp = recruitment.clickAddButton();

	}
	@DataProvider // Test util class for this setup
	public Object [] [] getCRMTestData() throws InvalidFormatException {
	Object data [] [] =	Test_Util.getTestData(Sheetname);
	return data;	
	
	}

	
	
	
	
	
	@Test(priority =1, dataProvider ="getCRMTestData")
	public void createNewCandidate(String FirstName, String MiddleName,String LastName, String Email) throws InterruptedException {
	//acp.creatNewCandidate("Tom", "Cruse", "Peter", "Tom@gmail.com");
		acp.creatNewCandidate(FirstName, MiddleName, LastName, Email);
		System.out.println("Candidate has been Added");
		
		Thread.sleep(3000);// Just putting some extra time to see result
	}



	@AfterMethod
	public void teardown() {
		teardownTestBase();
	}




}
