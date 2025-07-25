package setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set path to chromedriver if not in PATH  
//            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
	
	
	
	
}
