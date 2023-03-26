package com.softwaretestingboard.magento.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

	@FindBy (id="email")
	private WebElement emailInp;
	
	@FindBy (id="pass")
	private WebElement passwordInp;
	
	@FindBy (id="send2")
	private WebElement signInBtn;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void signIn(String email, String password) {
		emailInp.sendKeys(email);
		passwordInp.sendKeys(password);
		signInBtn.click();
	}
}
