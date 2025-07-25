package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import setup.DriverSetup;

public class Hook {

	public static WebDriver driver;
	
	
	@Before
	
	public void setUp() {
        driver = DriverSetup.getDriver();
    }
	
	@After
    public void tearDown() {
		DriverSetup.quitDriver();
    }
	
	
	
	
	
	
	
	
}
