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

	@FindBy(css = "button[class='btn btn-none-bg btn-login']")
	public static WebElement loginBtn;

	@FindBy(xpath = "(//div[@id='user-dropdown'])[1]")
	public static WebElement userDropdown;

	public WebElement getLoginBtn(){
		return loginBtn;
	}

	public boolean isLogin(){
		Waits.waitUntilElementLocated(10, userDropdown);
		if(userDropdown.isDisplayed()){
			return true;
		}
		return false;
	}




}
