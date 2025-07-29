package stepdefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.Hook;
import io.cucumber.java.en.*;
import pages.LibraryCard;

public class steps {

    WebDriver driver = Hook.driver;
    LibraryCard card;
    Properties prop = new Properties();
    FileInputStream fStream;

    @Given("the user is on the Library Card page")
    public void the_user_is_on_the_library_card_page() throws IOException {
        fStream = new FileInputStream(".//src//test//java//resources//config.properties");
        prop.load(fStream);
        driver.get(prop.getProperty("card_url"));
        card = new LibraryCard(driver);
    }

    // Input fields
    @When("the user leaves the First Name field blank")
    public void leave_first_name_blank() {
        card.enterFirstName("");
    }

    @When("the user enters {string} in the First Name field")
    public void enter_first_name(String value) {
        card.enterFirstName(value);
    }

    @When("the user enters {string} in the Last Name field")
    public void enter_last_name(String value) {
        card.enterLastName(value);
    }

    @When("the user enters {string} in the Age field")
    public void enter_age(String value) {
        card.enterAge(value);
    }

    @When("the user leaves the Age field blank")
    public void leave_age_blank() {
        card.enterAge("");
    }

    @When("the user enters {string} in the Email field")
    public void enter_email(String value) {
        card.enterEmail(value);
    }

    @When("the user enters {string} in the Phone field")
    public void enter_phone(String value) {
        card.enterPhone(value);
    }

    @When("the user enters {string} in the Company field")
    public void enter_company(String value) {
        card.enterCompany(value);
    }

    @When("the user enters {string} in the School field")
    public void enter_school(String value) {
        card.enterSchool(value);
    }

    // Radio buttons for role
    @When("the user selects Student from the Role radio options")
    public void select_student_role() {
        card.selectStudent();
    }

    @When("the user selects Employee from the Role radio options")
    public void select_employee_role() {
        card.selectEmployee();
    }

    // Dropdown
    @When("the user selects {string} from the Action dropdown")
    public void select_action_dropdown(String value) {
        card.selectAction(value); // e.g., "create"
    }

    // Submit
    @When("the user clicks on the Apply New Card button")
    public void click_submit_button() {
        card.clickSubmit();
    }

    // Error validations
    @Then("an inline error message should be displayed for First Name as {string}")
    public void validate_first_name_error(String expectedMessage) {
        String actual = card.getFirstNameError();
        Assert.assertEquals(expectedMessage, actual);
    }

    @Then("an inline error message should be displayed for Age as {string}")
    public void validate_age_error(String expectedMessage) {
        String actual = card.getAgeError();
        Assert.assertEquals(expectedMessage, actual);
    }

    // Success validation
    @Then("the form should be submitted successfully")
    public void verify_successful_submission() {
        Assert.assertTrue(driver.getPageSource().contains("ID"));
    }

    @Then("a library card should be displayed with name {string}")
    public void verify_name_on_card(String expectedFullName) {
        Assert.assertTrue(driver.getPageSource().contains(expectedFullName));
    }
}
