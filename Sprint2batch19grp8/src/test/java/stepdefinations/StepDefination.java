package stepdefinations;

import org.openqa.selenium.WebDriver;

import hooks.Hook;
import io.cucumber.java.en.*;
import pages.LibrarySearchPage;
import org.junit.Assert;

public class StepDefination{

    WebDriver driver = Hook.driver;
    LibrarySearchPage searchPage;

    @Given("the user is on the Advanced Search page")
    public void the_user_is_on_the_advanced_search_page() {
        driver.get("https://webapps.tekstac.com/SeleniumApp2/Library/advancedSearch.html"); // Replace with actual URL
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

    @Then("the search results should be displayed")
    public void the_search_results_should_be_displayed() {
        // Example check — you may update with actual result validation logic
        String pageTitle = driver.getTitle();
        Assert.assertTrue("Search results not displayed!", pageTitle.contains("Search Results"));
    }
}
