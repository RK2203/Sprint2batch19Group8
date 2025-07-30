package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import hooks.Hook;
import io.cucumber.java.en.*;
import pages.ServicesPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class ServicesStepDefinition {

    WebDriver driver = Hook.driver;
    ServicesPage servicesPage;
    Properties prop = new Properties();
    FileInputStream fStream;

    @Given("the user is on the Services form page")
    public void the_user_is_on_the_services_form_page() throws IOException {
        fStream = new FileInputStream(".//src//test//java//resources//config.properties");
        prop.load(fStream);

        driver.get(prop.getProperty("services_url"));
        servicesPage = new ServicesPage(driver);
    }

    @When("the user selects {string} option")
    public void the_user_selects_option(String option) {
        switch (option.toLowerCase()) {
            case "email":
                servicesPage.selectEmailMedium();
                break;
            case "call":
                servicesPage.selectCallMedium();
                break;
            case "chat":
                servicesPage.selectChatMedium();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    @When("the user enters {string} in the {string} field")
    public void the_user_enters_in_the_field(String value, String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "from":
                servicesPage.enterEmailDetails(value, servicesPage.getEmailQueryInput().getAttribute("value")); // preserve existing query
                break;

            case "to":
                WebElement toField = servicesPage.getToEmailInput();
                // Check if the field is disabled or readonly
                if (!toField.isEnabled() || toField.getAttribute("readonly") != null) {
                    System.out.println("To field is not editable. Skipping input.");
                } else {
                    toField.clear();
                    toField.sendKeys(value);
                }
                break;

            case "query":
                servicesPage.enterEmailDetails(servicesPage.getFromEmailInput().getAttribute("value"), value); // preserve existing from
                break;

            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }


    @When("the user clicks {string}")
    public void the_user_clicks(String buttonText) {
        if (buttonText.equalsIgnoreCase("submit")) {
            servicesPage.submitForm();
        }
    }

    @Then("the message {string} should appear")
    public void the_message_should_appear(String expectedMessage) {
        String actualMessage = servicesPage.getEmailSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user leaves {string} and {string} fields blank")
    public void the_user_leaves_fields_blank(String field1, String field2) {
        servicesPage.enterEmailDetails("", "");
    }

    @Then("the error message {string} should be shown")
    public void the_error_message_should_be_shown(String expectedError) {
        String fromError = servicesPage.getEmailFromError();
        String queryError = servicesPage.getEmailQueryError();
        String combinedError = (fromError + " " + queryError).trim().replaceAll("\\s+", " ");
        Assert.assertTrue(combinedError.contains(expectedError));
    }

    @Then("the error message {string} should be displayed below the From field")
    public void the_error_message_should_be_displayed_below_the_from_field(String expectedError) {
        String actualError = servicesPage.getEmailFromError();
        Assert.assertEquals(expectedError, actualError);
    }

    @Then("the {string} field should be auto-filled with {string}")
    public void the_field_should_be_auto_filled_with(String fieldName, String expectedValue) {
        if (fieldName.equalsIgnoreCase("to")) {
            String actualValue = servicesPage.getToEmailValue();
            Assert.assertEquals(expectedValue, actualValue);
            Assert.assertTrue("To field should be disabled", servicesPage.isToEmailDisabled());
        } else {
            throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }
}
