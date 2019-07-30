package com.training.pom;




import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.training.generics.GenericMethods;

import org.openqa.selenium.WebDriverException;


public class MediumTC1LoginPOM {
	private WebDriver driver; 
	private GenericMethods genericMethods;
	
	public MediumTC1LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//Login to URL http://uniform.upskills.in/admin as admin
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 
	
	//Navigation to catalog icon
	@FindBy(xpath="//*[@id=\"catalog\"]/a")
	private WebElement catalog;
	
	//Navigation to Product Link
	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[2]/a")
	private WebElement productLink;
	
	//Selecting a product named Grey Shirt
	@FindBy(xpath="//*[@id='form-product']/div/table/tbody/tr[3]/td[1]/input")
	private WebElement productBtn;
	
	//Selecting edit button of product item
	@FindBy(xpath="//*[@id=\"form-product\"]/div/table/tbody/tr[3]/td[8]/a")
	private WebElement productEditBtn;
	
	//Navigation to data tab
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
	private WebElement selectDataTab;
	
	@FindBy(id="input-quantity")
	private WebElement quantityValue;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement saveBtn;
	
	public void sendUserName(String userName) {
		genericMethods = new GenericMethods(driver);
		genericMethods.highlightElement(this.userName);
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCatalogBtn()
	{
		this.catalog.click();
	}
	
	public void clickProductLink()
	{
		this.productLink.click();
	}
	
	public void clickProductBtn()
	{
		genericMethods = new GenericMethods(driver);
		genericMethods.highlightElement(this.productBtn);
		this.productBtn.click();
	}
	public void clickProductEditBtn()
	{
		genericMethods = new GenericMethods(driver);
		genericMethods.highlightElement(this.productEditBtn);
		this.productEditBtn.click();
	}
	
	public void clickDataTab()
	{
		this.selectDataTab.click();
	}
	
	public void scrollPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	//Selecting Quantity textbox
	public void selectQuantityBox()
	{
		this.quantityValue.click();
	}
	
	//Setting value in Quantity textbox
	public void setQantityValue(String quantityValue) {
		this.quantityValue.clear(); 
		this.quantityValue.sendKeys(quantityValue);
	}
	
	//Saving the change
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}
}
