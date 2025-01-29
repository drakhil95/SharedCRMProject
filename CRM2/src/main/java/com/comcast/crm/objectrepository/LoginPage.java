package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	@FindBy(name = "user_name")
	private WebElement userNameTbx;
	
	@FindBy(name = "user_password")
	private WebElement passwordTbx;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTbx() {
		return userNameTbx;
	}

	public WebElement getPasswordtbx() {
		return passwordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void login(String url, String username, String passowrd) {
		driver.get(url);
		userNameTbx.sendKeys(username);
		passwordTbx.sendKeys(passowrd);
		loginBtn.click();
	}
	
}
