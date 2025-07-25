package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",       // Path to .feature files
    glue = {"stepdefinations", "hooks"},            // Package containing step defs & hooks
    plugin = {
        "pretty",
        "html:target/cucumber-reports/htmlReport.html",      // HTML report
        "json:target/cucumber-reports/report.json",           // JSON report
        "junit:target/cucumber-reports/report.xml"            // JUnit report
    },
    monochrome = true,
    dryRun = false,
    publish = false
)
public class Runner {
    // This class will be empty. All logic is handled by annotations.
}
