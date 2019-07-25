package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.SimpleTC3LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTC3LoginTest {


	private WebDriver driver; 
	private String baseUrl; 
	private SimpleTC3LoginPOM tc3_loginPOM; 
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
		tc3_loginPOM = new SimpleTC3LoginPOM(driver); 
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
			tc3_loginPOM.sendUserName("admin");
			tc3_loginPOM.sendPassword("admin@123");
			tc3_loginPOM.clickLoginBtn(); 
			tc3_loginPOM.clickCatalogBtn();
			tc3_loginPOM.clickCategoryBtn();
			tc3_loginPOM.findCategoryName();
			tc3_loginPOM.selectCategoryBtn();
			tc3_loginPOM.selectDeleteBtn();
			Alert alert=driver.switchTo().alert();
			alert.accept();
			//screenShot.captureScreenShot("First");
	}
	
	
}
