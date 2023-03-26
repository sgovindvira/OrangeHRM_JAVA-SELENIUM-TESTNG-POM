package com.Automation.TestsCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Automatio.Pages.HomePage;
import com.Automatio.Pages.LoginPage;
import com.autonation.base.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage lp; 
	HomePage homepage;

	/*
	public LoginPageTest() {
		super();
	}


	 */
	@BeforeMethod 
	public void setup() throws IOException {

		readConfigFile();
		intialization();
		lp= new LoginPage();
	}




	@Test(priority =1)

	public void titleTest() {
		String title =	lp.validateLoginPageTitle();
		System.out.println(title);
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}




	@Test(priority =2)
	public void validatingCRMimage() {

		Assert.assertTrue(lp.validateCRMImage());
	}

	@Test(priority =3)
	public void forgotPasswortdText() {

		AssertJUnit.assertTrue(lp.validatingForgotPasswordText());
	}


	@Test(priority=4)

	public void version() {

		AssertJUnit.assertTrue(lp.checkingVersion());
	}







	@Test(priority= 5)
	public void login() throws InterruptedException  {
		Thread.sleep(3000);


		homepage =lp.login(prop.getProperty("username"),prop.getProperty("password"));

		Thread.sleep(3000);

	}




	@AfterMethod
	public void closeBs() {
		teardownTestBase();
	}
}
