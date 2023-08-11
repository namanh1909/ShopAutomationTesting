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

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public static WebElement successMessage;

	public void doLogin(String email, String password) {
		Waits.waitUntilElementLocated(10,emailField);
		emailField.isDisplayed();
		emailField.sendKeys(email);
		Waits.waitUntilElementLocated(10, passwordField);
		passwordField.isDisplayed();
		passwordField.sendKeys(password);
		Waits.waitUntilElementToClick(10, loginButton);
		loginButton.click();
	}
	public boolean checkMessageInvalidAccount(){
		Waits.waitUntilElementLocated(20, warningMessage);
		return warningMessage.isDisplayed();
	}

	public boolean isSuccessSendEmail(){
		Waits.waitUntilElementLocated(20, successMessage);
		return successMessage.isDisplayed();
	}

}
