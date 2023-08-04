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

	@FindBy(xpath = "//input[contains(@placeholder,'Tên đăng nhập hoặc Email')]")
	public static WebElement emailField;

	@FindBy(xpath = "//input[@placeholder='Mật khẩu']")
	public static WebElement passwordField;

	@FindBy(xpath="//button[@class='btn btn-block btn-submit']")
	public static WebElement loginButton;

	@FindBy(xpath="//div[@class='alert-danger']")
	public static WebElement warningMessage;

	public void doLogin(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	public boolean checkMessageInvalidAccount(String message){
		Waits.waitUntilElementLocated(20, warningMessage);
		if(message == warningMessage.getText()) return true;
		return false;
	}


}
