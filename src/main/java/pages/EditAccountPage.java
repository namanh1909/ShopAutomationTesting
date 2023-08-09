package pages;

import base.Base;
import framework.Waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
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

    public void submitUpdateAccountForm(String type, String firstName, String lastName, String email, String telephone) {
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

    public boolean isShowSuccessUpdatedMessage() {
        Waits.waitUntilElementLocated(10, successUpdatedMessage);
        return successUpdatedMessage.isDisplayed();
    }

}
