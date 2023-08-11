package pages;
import base.Base;
import framework.Waits;
import gherkin.lexer.El;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Email;
import util.Validate;

public class RegisterPage {
    AccountPage accountPage = new AccountPage();
    Validate validate = new Validate();
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


    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public static WebElement checkboxValidate;

    public void submitForm(String fisrtName, String lastName, String email, String telephone, String password, String confirmPassword, String checkbox) {
        Waits.waitUntilElementLocated(10, firstname);
        firstname.isDisplayed();
        firstname.sendKeys(fisrtName);

        Waits.waitUntilElementLocated(10, lastname);
        lastname.isDisplayed();
        lastname.sendKeys(lastName);

        Waits.waitUntilElementLocated(10, emailInput);
        emailInput.isDisplayed();
        emailInput.sendKeys(email);

        Waits.waitUntilElementLocated(10, telephoneInput);
        telephoneInput.isDisplayed();
        telephoneInput.sendKeys(telephone);

        Waits.waitUntilElementLocated(10, passwordInput);
        passwordInput.isDisplayed();
        passwordInput.sendKeys(password);

        Waits.waitUntilElementLocated(10, confirmPasswordInput);
        confirmPasswordInput.isDisplayed();
        confirmPasswordInput.sendKeys(confirmPassword);

        Waits.waitUntilElementToClick(10, acpPolicyCheckbox);
        if (checkbox.equals("true")) {
            acpPolicyCheckbox.click();
        }
        Waits.waitUntilElementToClick(10, submitButton);
        submitButton.click();
    }

    public void doRegister(String type, String fisrtName, String lastName, String email, String telephone, String password, String confirmPassword, String checkbox) {
        if (type.equals("invalidEmail") || type.equals("alreadyEmail")) {
            submitForm(fisrtName, lastName, email, telephone, password, confirmPassword, checkbox);
        } else {
            submitForm(fisrtName, lastName, Email.getRandomEmail() + "@gmail.com", telephone, password, confirmPassword, checkbox);
        }
    }

    public boolean isShowAcpPolicyCheckboxValidate() {
        return checkboxValidate.isDisplayed();
    }


    public boolean isSuccessRegister(String type){
        switch(type) {
            case "valid":
                return accountPage.isRegisterSuccess();
            case "invalidFirstName":
                return validate.isShowFirstNameValidate();
            case "invalidLastName":
                return validate.isShowLastNameValidate();
            case "invalidEmail": return validate.isShowEmailValidate();
            case "invalidTelephone": return validate.isShowTelephoneValidate();
            case "invalidPassword": return validate.isShowPasswordValidate();
            case "invalidConfirmPassword": return validate.isShowConfirmPasswordValidate();
            case "dontCheck":
            case "alreadyEmail":
                return isShowAcpPolicyCheckboxValidate();
            // code block
            default:
                return false;
        }
    }
}
