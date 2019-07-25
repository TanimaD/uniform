package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC1LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC1LoginTest {


	private WebDriver driver; 
	private String baseUrl; 
	private TC1LoginPOM tc1_loginPOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		tc1_loginPOM = new TC1LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void loginPassTest() {
			tc1_loginPOM.sendUserName("admin");
			tc1_loginPOM.sendPassword("admin@123");
			tc1_loginPOM.clickLoginBtn(); 
			//screenShot.captureScreenShot("First");
	}
	
	
}
