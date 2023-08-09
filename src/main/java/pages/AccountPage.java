package pages;

import base.Base;
import framework.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public AccountPage() {
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    public static WebElement editAccountOption;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    public static WebElement suscessRegisterText;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Forgotten Password']")
    public static WebElement forgotPasswordOption;

    @FindBy(xpath = "//a[normalize-space()='Edit Account']")
    public static WebElement editInformation;

    public void navigateToForgotPassword(){
        Waits.waitUntilElementToClick(10,forgotPasswordOption);
        forgotPasswordOption.click();
    }

    public void navigateToEditInformation(){
        Waits.waitUntilElementToClick(10,editInformation);
        editInformation.click();
    }

    public boolean isLogin(){
        Waits.waitUntilElementLocated(10, editAccountOption);
        return editAccountOption.isDisplayed();
    }

    public boolean isRegisterSuccess(){
        Waits.waitUntilElementLocated(10, suscessRegisterText);
        return suscessRegisterText.isDisplayed();
    }

}
