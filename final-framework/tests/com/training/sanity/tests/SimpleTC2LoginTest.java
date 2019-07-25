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
import com.training.pom.SimpleTC2LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTC2LoginTest {


	private WebDriver driver; 
	private String baseUrl; 
	private SimpleTC2LoginPOM tc2_loginPOM; 
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
		tc2_loginPOM = new SimpleTC2LoginPOM(driver); 
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
			tc2_loginPOM.sendUserName("admin");
			tc2_loginPOM.sendPassword("admin@123");
			tc2_loginPOM.clickLoginBtn(); 
			tc2_loginPOM.clickCatalogBtn();
			tc2_loginPOM.clickCategoryBtn();
			//screenShot.captureScreenShot("First");
	}
	
	
}
