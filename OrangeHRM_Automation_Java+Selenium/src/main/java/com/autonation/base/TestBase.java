package com.autonation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.util.Test_Util;

public class TestBase {


	public	static WebDriver driver;
	public	static Properties prop;
	public static JavascriptExecutor jse;
	//Update Testing for github
	
/*
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream fp = new FileInputStream("/Users/sanjay/eclipse-workspace/Automation_CRM_2/src/main/java/crm/automation/config/config.properties");
		prop.load(fp);

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}


	
*/



	public static void readConfigFile() throws IOException {
		prop = new Properties();
		FileInputStream fp = new FileInputStream("/Users/sanjay/eclipse-workspace/OrangeHRM_Automation_Java+Selenium/src/main/java/crm/automation/config/config.properties");
		prop.load(fp);
	     }


	public static void intialization() {
		String browsernName =	prop.getProperty("browser");

		if(browsernName.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browsernName.equals("Firefox")) {
			driver = new FirefoxDriver();	
		}else {
			System.out.println("Browser name is not specified");
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Test_Util.Page_Load_TimeOut));// Coming from Test Util class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Test_Util.impWait));//Time coming from Test Util class

		driver.get(prop.getProperty("url"));

		jse	 =(JavascriptExecutor)driver;

	}

	public void teardownTestBase() {
		driver.quit();
	}






}
