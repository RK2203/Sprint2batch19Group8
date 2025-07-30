package stepdefinations;

import org.openqa.selenium.WebDriver;


import hooks.Hook;
import io.cucumber.java.en.*;
import pages.LibrarySearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;

public class StepDefination {

    WebDriver driver = Hook.driver;
    LibrarySearchPage searchPage;
    
    
    Properties prop = new Properties();
    
    FileInputStream fStream;
    
    
    
    @Given("the user is on the Advanced Search page")
    public void the_user_is_on_the_advanced_search_page() throws IOException{
    	
    	
    	fStream = new FileInputStream(".//src//test//java//resources//config.properties");
    	prop.load(fStream);
    	
    	
    	System.out.println(prop.getProperty("search_url"));
    	
        driver.get(prop.getProperty("search_url")); // Replace with actual URL
        searchPage = new LibrarySearchPage(driver);
    }

    @When("the user enters author name as {string}")
    public void the_user_enters_author_name_as(String authorName) {
        searchPage.enterAuthorName(authorName);
    }

    @When("the user enters subject as {string}")
    public void the_user_enters_subject_as(String subject) {
        searchPage.enterSubject(subject);
    }

    @When("the user selects edition as {string}")
    public void the_user_selects_edition_as(String edition) {
        searchPage.selectEdition(edition);
    }

    @When("the user selects format as {string}")
    public void the_user_selects_format_as(String format) {
        searchPage.selectFormat(format);
    }

    @When("the user selects age group as {string}")
    public void the_user_selects_age_group_as(String ageGroup) {
        searchPage.selectAgeGroup(ageGroup);
    }

    @When("the user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        searchPage.clickSearch();
    }
    
    @When("the user does not select any age group")
    
    public void the_user_does_not_select_any_age_group() {
    	
    }
    
    
    
    @When("the user checks the available options in the Book Format dropdown")
    public void the_user_checks_the_available_options_in_the_book_format_dropdown() {
        // No action needed; just preparing to verify in next step
    }

    @Then("the Book Format dropdown should contain the following options:")
    public void the_book_format_dropdown_should_contain_the_following_options(List<String> expectedOptions) {
        List<String> actualOptions = searchPage.getBookFormatOptions();
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Then("the search results should be displayed")
    public void the_search_results_should_be_displayed() {
        // Example check — you may update with actual result validation logic
        String pageTitle = driver.getTitle();
        Assert.assertTrue("Search results not displayed!", pageTitle.contains("Search Results"));
    }
    
    @Then("an inline error should be shown with message {string}")
    public void an_inline_error_should_be_shown_with_message(String expectedMessage) {
        String actualError = searchPage.getAuthorNameError();
        Assert.assertEquals(expectedMessage, actualError);
    }
    
    
    @Then("an inline error should be shown with message of age {string}")
    public void an_inline_error_should_be_shown_with_message_of_age(String expectedMessage) {
        String actualError = searchPage.getAgeGroupError();
        Assert.assertEquals(expectedMessage, actualError);
    }
    
    @When("the user leaves edition as default")
    public void the_user_leaves_edition_as_default() {
        // Do nothing — default is already "Select"
    }

    @Then("an inline error should be shown with message of {string}")
    public void an_inline_error_should_be_shown_with_message_of(String expectedMsg) {
        String actualMsg = searchPage.getEditionErrorMessage(); // You must implement this
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    
}
