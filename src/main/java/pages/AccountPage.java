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

    public boolean isLogin(){
        Waits.waitUntilElementLocated(10, editAccountOption);
        if(editAccountOption.isDisplayed()){
            return true;
        }
        return false;
    }

}
