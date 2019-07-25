package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebDriverException;

public class SimpleTC3LoginPOM {
	private WebDriver driver; 
	
	public SimpleTC3LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"catalog\"]/a")
	private WebElement catalog;
	
	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[1]/a")
	private WebElement category;
	
	@FindBy(xpath="//*[@id='form-category']/div/table/tbody/tr[1]/td[2]")
	private WebElement categoryName;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/div/table/tbody/tr[1]/td[1]/input[@name='selected[]']")
	private WebElement selectCategoryName;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement selectDeleteBtn;
	
	
	public void sendUserName(String userName) {
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
	
	public void clickCategoryBtn()
	{
		this.category.click();
	}
	 
	public void findCategoryName()
		{
			this.categoryName.click();
		}
	public void selectCategoryBtn()
	{
		this.selectCategoryName.click();
	}
	
	public void selectDeleteBtn()
	{
		this.selectDeleteBtn.click();
	}
	
}
