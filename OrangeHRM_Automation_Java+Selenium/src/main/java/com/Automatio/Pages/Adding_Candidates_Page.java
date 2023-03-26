package com.Automatio.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autonation.base.TestBase;

public class Adding_Candidates_Page extends TestBase {
	
	
	@FindBy(name ="firstName")
	WebElement firstName;
	
	
	@FindBy(name="middleName")
	WebElement middleName;
	
	@FindBy(name ="lastName")
	WebElement lastname;
	
	@FindBy(xpath ="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement email;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement SaveButton;
	
	
	public Adding_Candidates_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void creatNewCandidate(String fname,String midName,String lname, String mail) {
		
		firstName.sendKeys(fname);
		middleName.sendKeys(midName);
		lastname.sendKeys(lname);
		email.sendKeys(mail);
		SaveButton.click();
		
		
	}
	
	

}
