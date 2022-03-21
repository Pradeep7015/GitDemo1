package Steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue="Steps", monochrome=true,
plugin= {"pretty","html:target/HTMLreports","json:target/JSON/jsonreport"})
public class Testrunner {

}
