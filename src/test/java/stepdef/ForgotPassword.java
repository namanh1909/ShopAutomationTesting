package stepdef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.ForgotPasswordPage;
import pages.HeadersSection;
import pages.LoginPage;

public class ForgotPassword {
    HeadersSection headersSection = new HeadersSection();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    @And("^I navigate to Login page and then navigate to Forgot password page$")
    public void iNavigateToLoginPageAndThenNavigateToForgotPasswordPage() {
        headersSection.navigateToLoginPage();
        accountPage.navigateToForgotPassword();
    }

    @When("^I enter email value \"([^\"]*)\" and click continue button$")
    public void iEnterEmailValueAndClickContinueButton(String email) {
        // Write code here that turns the phrase above into concrete actions
        forgotPasswordPage.submitForm(email);
    }

    @Then("^I should see navigate to login page and have a message success send email$")
    public void iShouldSeeNavigateToLoginPageAndHaveAMessageSuccessSendEmail() {
        Assert.assertTrue(loginPage.isSuccessSendEmail());
    }

    @Then("^I should see message error invalid email$")
    public void iShouldSeeMessageErrorInvalidEmail() {
        Assert.assertTrue(forgotPasswordPage.isShowEmailValidate());
    }

}
