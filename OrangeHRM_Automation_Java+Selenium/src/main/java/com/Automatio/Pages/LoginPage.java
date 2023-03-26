package com.Automatio.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autonation.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name ="username")
	WebElement username;

	@FindBy(name= "password")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBttn;

	@FindBy(xpath ="//div[@class='orangehrm-login-forgot']/p")
	WebElement forgotPasswortdText;


	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")
	WebElement  logo;

	@FindBy(xpath="//img[@alt='orangehrm-logo'][1]")
	WebElement smallLogo;

	@FindBy(xpath ="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/p[1]")
	WebElement version;


	public LoginPage () {
		PageFactory.initElements(driver, this);


	}


	public String validateLoginPageTitle() {
		return driver.getTitle();
	}


	public boolean validatingForgotPasswordText() {
		System.out.println(forgotPasswortdText.getText());
		return	forgotPasswortdText.isDisplayed();

	}


	public boolean checkingVersion() {
		System.out.println("Version of this application is " +version.getText());
		return version.isDisplayed();
	}


	public boolean validateCRMImage() {
		return smallLogo.isDisplayed();
	}

	public HomePage login(String uname,String pwd) {

		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBttn.click();


		return new HomePage();

	}



}
