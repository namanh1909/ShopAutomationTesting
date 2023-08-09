package pages;
import base.Base;
import cucumber.api.java.cs.A;
import framework.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.Charset;
import java.util.Random;

public class RegisterPage {
    AccountPage accountPage = new AccountPage();
    public RegisterPage() {
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    public static WebElement firstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public static WebElement lastname;

    @FindBy(xpath = "//input[@id='input-email']")
    public static WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-telephone']")
    public static WebElement telephoneInput;

    @FindBy(xpath = "//input[@id='input-password']")
    public static WebElement passwordInput;

    @FindBy(xpath = "//input[@id='input-confirm']")
    public static WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@name='agree']")
    public static WebElement acpPolicyCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    public static WebElement submitButton;

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

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
        public static WebElement checkboxValidate;

    public void doRegister(String type, String fisrtName, String lastName, String email, String telephone, String password, String confirmPassword, String checkbox){


        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        if(type.equals("invalidEmail") || type.equals("alreadyEmail")){
            firstname.sendKeys(fisrtName);
            lastname.sendKeys(lastName);
            emailInput.sendKeys(email);
            telephoneInput.sendKeys(telephone);
            passwordInput.sendKeys(password);
            confirmPasswordInput.sendKeys(confirmPassword);
            Waits.waitUntilElementToClick(10, acpPolicyCheckbox);
            if(checkbox.equals("true")){
                acpPolicyCheckbox.click();
            }
            submitButton.click();
        }
        else {
            firstname.sendKeys(fisrtName);
            lastname.sendKeys(lastName);
            emailInput.sendKeys(generatedString + "@gmail.com");
            telephoneInput.sendKeys(telephone);
            passwordInput.sendKeys(password);
            confirmPasswordInput.sendKeys(confirmPassword);
            Waits.waitUntilElementToClick(10, acpPolicyCheckbox);
            if(checkbox.equals("true")){
                acpPolicyCheckbox.click();
            }
            submitButton.click();
        }


    }

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

    public boolean isShowAcpPolicyCheckboxValidate(){
        return checkboxValidate.isDisplayed();
    }

    public boolean isSuccessRegister(String type){
        switch(type) {
            case "valid":
                return accountPage.isRegisterSuccess();
            case "invalidFirstName":
                return isShowFirstNameValidate();
            case "invalidLastName":
                return isShowLastNameValidate();
            case "invalidEmail": return isShowEmailValidate();
            case "invalidTelephone": return isShowTelephoneValidate();
            case "invalidPassword": return isShowPasswordValidate();
            case "invalidConfirmPassword": return isShowConfirmPasswordValidate();
            case "dontCheck":
            case "alreadyEmail":
                return isShowAcpPolicyCheckboxValidate();
            // code block
            default:
                return false;
        }
    }
}
