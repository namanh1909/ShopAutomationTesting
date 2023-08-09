package pages;

import base.Base;
import framework.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    public ForgotPasswordPage() {
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
    public  static WebElement title;

    @FindBy(id = "input-email")
    public static WebElement emailField;

    @FindBy(css = "input[type='submit'][value='Continue']\r\n")
    public static WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public static WebElement emailValidate;

    public boolean isShowEmailValidate(){
        Waits.waitUntilElementLocated(10, emailValidate);
        return emailValidate.isDisplayed();
    }

    public void submitForm(String email){
        emailField.sendKeys(email);
        continueButton.click();
    }


}
