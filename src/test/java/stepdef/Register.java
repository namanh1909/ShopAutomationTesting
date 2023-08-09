package stepdef;
import cucumber.api.PendingException;
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

    @Then("^If register success, navigate to account page and show message\\. Else show error message \"([^\"]*)\"$")
    public void ifRegisterSuccessNavigateToAccountPageAndShowMessageElseShowErrorMessage(String type) throws Throwable {
        Assert.assertTrue(registerPage.isSuccessRegister(type));
    }

    @When("^Enter information for all required fields \\(First Name \"([^\"]*)\" \"([^\"]*)\", Last Name \"([^\"]*)\", Email \"([^\"]*)\", Telephone \"([^\"]*)\", Password \"([^\"]*)\", Confirm Password \"([^\"]*)\", checkbox \"([^\"]*)\"\\)$")
    public void enterInformationForAllRequiredFieldsFirstNameLastNameEmailTelephonePasswordConfirmPasswordCheckbox(String type, String firstName, String lastName, String email, String telephone, String password, String confirmPassword, String checkbox) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        registerPage.doRegister(type,firstName, lastName, email, telephone, password, confirmPassword, checkbox);
    }
}
