package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MediumTC2LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumTC2LoginTest {


	private WebDriver driver; 
	private String baseUrl; 
	private MediumTC2LoginPOM tc2_loginPOM; 
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
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		tc2_loginPOM = new MediumTC2LoginPOM(driver); 
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
		tc2_loginPOM.clickProductLink();
		tc2_loginPOM.scrollPage();
		tc2_loginPOM.clickProductBtn();
		tc2_loginPOM.clickProductDeleteBtn();//How to place wait here to display product few more time
		Alert alert=driver.switchTo().alert();
		alert.accept();
			//screenShot.captureScreenShot("First");
	}
	
	
}
