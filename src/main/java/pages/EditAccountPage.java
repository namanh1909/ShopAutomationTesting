package pages;

import base.Base;
import framework.Waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Email;
import util.Validate;

public class EditAccountPage {
    Validate validate = new Validate();
    public EditAccountPage() {
        PageFactory.initElements(Base.driver, this);
    }
    @FindBy(xpath = "//h1[normalize-space()='My Account Information']")
    public static WebElement title;

    @FindBy(xpath = "//input[@id='input-firstname']")
    public static WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public static WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='input-email']")
    public static WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-telephone']")
    public static WebElement telephoneInput;

    @FindBy(xpath = "//input[@value='Continue']")
    public static WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public static WebElement successUpdatedMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public static WebElement alreadyEmailMessage;

    public void submitUpdateAccountForm(String type, String firstName, String lastName, String email, String telephone) {
        if(type.equals("invalidEmail") || type.equals("alreadyEmail") || type.equals("valid")){
            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            emailInput.clear();
            emailInput.sendKeys(email);
            telephoneInput.clear();
            telephoneInput.sendKeys(telephone);
            continueButton.click();
        }
        else {
            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            emailInput.clear();
            emailInput.sendKeys(Email.getRandomEmail() + "@gmail.com");
            telephoneInput.clear();
            telephoneInput.sendKeys(telephone);
            continueButton.click();
        }
    }

    public boolean isShowSuccessUpdatedMessage(){
        Waits.waitUntilElementLocated(10, successUpdatedMessage);
        return successUpdatedMessage.isDisplayed();
    }

    public void isShowSuccessUpdated(String type) {
        switch(type) {
            case "valid":
                isShowSuccessUpdatedMessage();
                return;
            case "invalidFirstName":
                validate.isShowFirstNameValidate();
                return;
            case "invalidLastName":
                validate.isShowLastNameValidate();
                return;
            case "invalidEmail":
                validate.isShowEmailValidate();
                return;
            case "invalidTelephone":
                validate.isShowTelephoneValidate();
                return;
            case "alreadyEmail":
                alreadyEmailMessage.isDisplayed();
                return;
            // code block
            default:
        }

    }

}
