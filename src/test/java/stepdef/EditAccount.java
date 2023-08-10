package stepdef;

import base.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.EditAccountPage;
import pages.HeadersSection;
import pages.LoginPage;

public class EditAccount {
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    HeadersSection headersSection = new HeadersSection();
    EditAccountPage editAccountPage = new EditAccountPage();

    @And("^I navigate to the Login page and I login to account and I navigate to the Edit Account page$")
    public void iNavigateToTheLoginPageAndILoginToAccountAndINavigateToTheEditAccountPage() {
        headersSection.navigateToLoginPage();
        loginPage.doLogin(Base.reader.getUsername(), Base.reader.getPassword());
        accountPage.navigateToEditInformation();
    }

    @Then("^Navigate to Login page and show a success message$")
    public void navigateToLoginPageAndShowASuccessMessage() {
        Assert.assertTrue(editAccountPage.isShowSuccessUpdatedMessage());
    }

    @When("^I submit the account edit form with new details with \"([^\"]*)\" \\(firstName \"([^\"]*)\", lastName \"([^\"]*)\", email \"([^\"]*)\", telephone \"([^\"]*)\"$")
    public void iSubmitTheAccountEditFormWithNewDetailsWithFirstNameLastNameEmailTelephone(String type, String firstName, String lastName, String email, String telephone) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editAccountPage.submitUpdateAccountForm(type ,firstName, lastName, email, telephone);
    }

    @Then("^If edit success Navigate to Login page and show a success message, else I should see message firstName error \"([^\"]*)\"$")
    public void ifEditSuccessNavigateToLoginPageAndShowASuccessMessageElseIShouldSeeMessageFirstNameError(String type) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editAccountPage.isShowSuccessUpdated(type);

    }
}
