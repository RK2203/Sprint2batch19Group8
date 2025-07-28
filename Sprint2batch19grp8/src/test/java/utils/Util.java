package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Util {

    public static String captureScreenshot(WebDriver driver, String scenarioName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "target/screenshots/" + scenarioName.replaceAll(" ", "_") + ".png";
            File destFile = new File(screenshotPath);
            destFile.getParentFile().mkdirs(); // create directory if not exists
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return destFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
