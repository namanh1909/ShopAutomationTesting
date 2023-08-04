package pages;

import framework.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LoginPage {
	
	public LoginPage() {

		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	public static WebElement emailField;

	@FindBy(xpath = "//input[@id='input-password']")
	public static WebElement passwordField;

	@FindBy(xpath="//input[@value='Login']")
	public static WebElement loginButton;

	@FindBy(xpath="//i[@class='fa fa-exclamation-circle']")
	public static WebElement warningMessage;

	public void doLogin(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	public boolean checkMessageInvalidAccount(){
		Waits.waitUntilElementLocated(20, warningMessage);
		if(warningMessage.isDisplayed()) return true;
		return false;
	}


}
