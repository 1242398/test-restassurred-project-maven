package runners.users;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/users",
        glue = {"stepDefinationUsers"},
        //plugin = { "pretty"},
        monochrome = true,
        strict = true
)
public class TestRunnerUsers {


}
