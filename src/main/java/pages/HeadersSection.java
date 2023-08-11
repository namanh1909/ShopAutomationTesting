package pages;

import framework.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HeadersSection {

	public HeadersSection() {
		PageFactory.initElements(Base.driver, this);
	}


	@FindBy(xpath = "//span[normalize-space()='My Account']")
	public static WebElement myAccountDropdown;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	public static WebElement loginOption;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	public static WebElement registerOption;

	public void navigateToLoginPage(){
		Waits.waitUntilElementToClick(10,myAccountDropdown);
		myAccountDropdown.click();
		Waits.waitUntilElementToClick(10,loginOption);
		loginOption.click();
	}

	public void navigateToRegisterPage(){
		Waits.waitUntilElementToClick(10,myAccountDropdown);
		myAccountDropdown.click();
		Waits.waitUntilElementToClick(10,registerOption);
		registerOption.click();
	}

}
