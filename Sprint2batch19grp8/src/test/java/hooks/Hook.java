package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import setup.DriverSetup;
import io.cucumber.java.Scenario;
import utils.Util;
public class Hook {

	public static WebDriver driver;
	
	
	@Before
	
	public void setUp() {
        driver = DriverSetup.getDriver();
    }
	
	@After
	public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String path = Util.captureScreenshot(driver, scenario.getName());
            if (path != null) {
                // Attach screenshot to report
                scenario.attach(path.getBytes(), "image/png", "Failed Screenshot");
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
	
	
	
	
	
	
	
	
}
