package setup;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        // Fix: Ensure fresh driver if previous one is invalid
        if (driver == null || ((ChromeDriver) driver).getSessionId() == null) {
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
