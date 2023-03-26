package com.Automatio.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autonation.base.TestBase;

public class HomePage extends TestBase {

	@FindBy (xpath= "//ul[@class='oxd-main-menu']/li[1]")
	WebElement adminName;

	@FindBy(xpath ="//title[contains(text(),'OrangeHRM')]")
	WebElement title;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement userName;  //. gettext


	@FindBy(xpath = "//body//a")
	List<WebElement> allLinks;
	
	
	@FindBy(xpath ="//ul[@class='oxd-main-menu']//li[5]")
	WebElement recruitmentPage;








	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public String verifyTitleHomepage() {
		return driver.getTitle();
	}
	
	

	public String checkingUser()
	{
		return	userName.getText();
	}

	public void checkingLinks() {
		
	List	<WebElement> links = allLinks;
	System.out.println(links.size());
		for(int i=0; i<links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
	}

	
	public Recruitment_Page clickingRecuitment() {
		 recruitmentPage.click();
		 return new Recruitment_Page();
		
	}







}
