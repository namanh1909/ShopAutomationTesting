package pages;
import base.Base;
import framework.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
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

    @FindBy(xpath = "///div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    public static WebElement emailValidate;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    public static WebElement telephoneValidate;

    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    public static WebElement passwordValidate;

    @FindBy(xpath = "//div[@class='text-danger']")
    public static WebElement confirmPasswordValidate;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
        public static WebElement checkboxValidate;

    public void doRegister(String fisrtName, String lastName, String email, String telephone, String password, String confirmPassword, String checkbox){
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

    public boolean isShowFirstNameValidate(){
        if(firstNameValidate.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isShowLastNameValidate(){
        if(lastNameValidate.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isShowEmailValidate(){
        if(emailValidate.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isShowTelephoneValidate(){
        if(telephoneValidate.isDisplayed()){
            return true;
        }
        return false;
    }
    public boolean isShowPasswordValidate(){
        if(passwordValidate.isDisplayed()){
            return true;
        }
        return false;
    }
    public boolean isShowConfirmPasswordValidate(){
        if(confirmPasswordValidate.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isShowAcpPolicyCheckboxValidate(){
        if(checkboxValidate.isDisplayed()){
            return true;
        }
        return false;
    }


}
