package util;

import base.Base;
import framework.Waits;
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
        Waits.waitUntilElementLocated(10,firstNameValidate);
         return firstNameValidate.isDisplayed();
    }

    public boolean isShowLastNameValidate(){
        Waits.waitUntilElementLocated(10,lastNameValidate);
        return lastNameValidate.isDisplayed();
    }

    public boolean isShowEmailValidate(){
        Waits.waitUntilElementLocated(10,emailValidate);
        return emailValidate.isDisplayed();
    }

    public boolean isShowTelephoneValidate(){
        Waits.waitUntilElementLocated(10,telephoneValidate);

        return telephoneValidate.isDisplayed();
    }
    public boolean isShowPasswordValidate(){
        Waits.waitUntilElementLocated(10,passwordValidate);

        return passwordValidate.isDisplayed();
    }
    public boolean isShowConfirmPasswordValidate(){
        Waits.waitUntilElementLocated(10,confirmPasswordValidate);
        return confirmPasswordValidate.isDisplayed();
    }




}
