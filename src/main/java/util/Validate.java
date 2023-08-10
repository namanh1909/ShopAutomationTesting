package util;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate {
    public Validate() {
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public static WebElement firstNameValidate;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    public static WebElement lastNameValidate;

    @FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    public static WebElement emailValidate;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    public static WebElement telephoneValidate;

    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    public static WebElement passwordValidate;

    @FindBy(xpath = "//div[@class='text-danger']")
    public static WebElement confirmPasswordValidate;


    public boolean isShowFirstNameValidate(){
        return firstNameValidate.isDisplayed();
    }

    public boolean isShowLastNameValidate(){
        return lastNameValidate.isDisplayed();
    }

    public boolean isShowEmailValidate(){
        return emailValidate.isDisplayed();
    }

    public boolean isShowTelephoneValidate(){
        return telephoneValidate.isDisplayed();
    }
    public boolean isShowPasswordValidate(){
        return passwordValidate.isDisplayed();
    }
    public boolean isShowConfirmPasswordValidate(){
        return confirmPasswordValidate.isDisplayed();
    }




}
