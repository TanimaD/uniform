package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MediumTC1LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumTC1LoginTest {


	private WebDriver driver; 
	private String baseUrl; 
	private MediumTC1LoginPOM tc1_loginPOM; 
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
		tc1_loginPOM = new MediumTC1LoginPOM(driver); 
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
		tc1_loginPOM.clickCatalogBtn();
		tc1_loginPOM.clickProductLink();
		tc1_loginPOM.scrollPage();
		tc1_loginPOM.clickProductBtn();
		tc1_loginPOM.clickProductEditBtn();//How to place wait here to display product few more time
		tc1_loginPOM.clickDataTab();
		tc1_loginPOM.scrollPage();
		tc1_loginPOM.selectQuantityBox();
		tc1_loginPOM.setQantityValue("100");
		tc1_loginPOM.clickSaveBtn();
			//screenShot.captureScreenShot("First");
	}
	
	
}
