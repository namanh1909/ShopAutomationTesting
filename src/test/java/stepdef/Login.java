package stepdef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.Browser;
import org.junit.Assert;
import pages.AccountPage;
import pages.HeadersSection;
import pages.LoginPage;


public class Login {
	HeadersSection headersSection = new HeadersSection();
	LoginPage loginPage = new LoginPage();
	AccountPage accountPage = new AccountPage();
	@Given("^I launch the application$")
	public void iLaunchTheApplication() {
		Browser.openApplication();
	}

	@And("^I navigate to Login page$")
	public void i_navigate_to_Account_Login_page() {
		headersSection.navigateToLoginPage();
	}

	@When("^I login to the Application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_Application_using_Username_and_Password(String email, String password) {
		loginPage.doLogin(email, password);
	}

	@Then("^I should see that the user is able to login successfully$")
	public void i_should_see_that_the_user_is_able_to_login_successfully() {
		Assert.assertTrue(accountPage.isLogin());
	}

	@Then("^I should see a error message that the credentials invalid$")
	public void iShouldSeeAErrorMessageThatTheCredentialsInvalid() {
		Assert.assertTrue(loginPage.checkMessageInvalidAccount());
	}
}
