package stepdef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.HeadersSection;
import pages.RegisterPage;

public class Register {
    HeadersSection headersSection = new HeadersSection();
    RegisterPage registerPage = new RegisterPage();
    AccountPage accountPage = new AccountPage();
    @And("^I navigate to register page$")
    public void iNavigateToRegisterPage() {
        headersSection.navigateToRegisterPage();
    }

    @When("^Enter information for all required fields \\(First Name \"([^\"]*)\", Last Name \"([^\"]*)\", Email \"([^\"]*)\", Telephone \"([^\"]*)\", Password \"([^\"]*)\", Confirm Password \"([^\"]*)\", checkbox \"([^\"]*)\"\\)$")
    public void enterValidInformationForAllRequiredFieldsFirstNameLastNameEmailTelephonePasswordConfirmPasswordCheckbox(String fisrtName, String lastName, String email, String telephone, String password, String confirmPassword, String checkbox)  {
        registerPage.doRegister(fisrtName,lastName,email, telephone,password,confirmPassword,checkbox);
    }

    @Then("^The registration is successful and the user is redirected to the success page\\.$")
    public void theRegistrationIsSuccessfulAndTheUserIsRedirectedToTheSuccessPage() {
       Assert.assertTrue(accountPage.isRegisterSuccess());
    }

    @Then("^I should see a firstName error message that the credentials invalid$")
    public void iShouldSeeAFirstNameErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowFirstNameValidate());
    }

    @Then("^I should see a lastName error message that the credentials invalid$")
    public void iShouldSeeALastNameErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowLastNameValidate());
    }

    @Then("^I should see a email error message that the credentials invalid$")
    public void iShouldSeeAEmailErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowEmailValidate());
    }

    @Then("^I should see a telephone error message that the credentials invalid$")
    public void iShouldSeeATelephoneErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowTelephoneValidate());
    }


    @Then("^I should see a passwordInValid error message that the credentials invalid$")
    public void iShouldSeeAPasswordInValidErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowPasswordValidate());
    }

    @Then("^I should see a confirmPasswordInValid error message that the credentials invalid$")
    public void iShouldSeeAConfirmpasswordErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowConfirmPasswordValidate());
    }

    @Then("^I should see a policy error message that the credentials invalid$")
    public void iShouldSeeAPolicyErrorMessageThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowAcpPolicyCheckboxValidate());
    }

    @Then("^I should see a email error message on the form that the credentials invalid$")
    public void iShouldSeeAEmailErrorMessageOnTheFormThatTheCredentialsInvalid() {
        Assert.assertTrue(registerPage.isShowAcpPolicyCheckboxValidate());
    }
}
