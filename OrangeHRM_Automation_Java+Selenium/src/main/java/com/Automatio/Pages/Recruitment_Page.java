package com.Automatio.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autonation.base.TestBase;

public class Recruitment_Page extends TestBase {
	
	@FindBy(xpath = "//nav[@role='navigation']//li[1]")
	WebElement candidatesLinnk;
	
	@FindBy(xpath ="//nav[@role='navigation']//li[2]")
	WebElement vacancies;
	
	@FindBy(xpath ="//div[@class='orangehrm-paper-container']/div/button")
	WebElement addRecruiterButton;
	
	
	public Recruitment_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyingRecrutitmentPage() {
		System.out.println("Checking Recruitmemt Page " );
	return	candidatesLinnk.isDisplayed();
	}
	
	public void clickingVacanicies() throws InterruptedException {
		vacancies.click();
		System.out.println("Clicked on Vacancies");
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Navigated back to Candidates's page");
		
		
		
	}
	
	public Adding_Candidates_Page clickAddButton() {
		addRecruiterButton.click();
		return new Adding_Candidates_Page();
	}
	
	

}
