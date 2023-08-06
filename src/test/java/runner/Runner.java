package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "classpath:FeatureFiles/ForgotPassword.feature" },
		glue = {"classpath:stepdef" },
		plugin = { "html:target/cucumber_html_report" },
		tags= {"@forgotPassword",}
)
public class Runner {

}
