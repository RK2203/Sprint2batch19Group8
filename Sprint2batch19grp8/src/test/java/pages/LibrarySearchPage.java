package pages;

import java.nio.channels.SelectableChannel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object Model for the Advanced Search section.
 */
public class LibrarySearchPage {
    WebDriver driver;

    // Constructor
    public LibrarySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Author Name input field
    @FindBy(id = "authorName")
    private WebElement authorNameInput;

    // Subject input field
    @FindBy(id = "subject")
    private WebElement subjectInput;

    // Edition dropdown
    @FindBy(id = "edition")
    private WebElement editionDropdown;

    // Format dropdown
    @FindBy(id = "format")
    private WebElement formatDropdown;

    // Age group radio buttons
    @FindBy(id = "ageGroup_kids")
    private WebElement ageGroupKids;

    @FindBy(id = "ageGroup_teen")
    private WebElement ageGroupTeen;

    @FindBy(id = "ageGroup_adult")
    private WebElement ageGroupAdult;

    // Search Submit button
    @FindBy(id = "searchSubmit")
    private WebElement searchSubmitButton;

    // Action Methods
    public void enterAuthorName(String author) {
        authorNameInput.clear();
        authorNameInput.sendKeys(author);
    }

    public void enterSubject(String subject) {
        subjectInput.clear();
        subjectInput.sendKeys(subject);
    }

    public void selectEdition(String editionValue) {
      
    	Select select = new Select(editionDropdown);
    	
    	select.selectByVisibleText(editionValue);
    	
    }

    public void selectFormat(String formatValue) {
       
    	Select select = new Select(formatDropdown);
    	select.selectByVisibleText(formatValue);
    	
    }

    public void selectAgeGroup(String ageGroup) {
        switch (ageGroup.toLowerCase()) {
            case "kids":
                ageGroupKids.click();
                break;
            case "teen":
                ageGroupTeen.click();
                break;
            case "adult":
                ageGroupAdult.click();
                break;
        }
    }

    public void clickSearch() {
        searchSubmitButton.click();
    }


    public void performAdvancedSearch(String author, String subject, String edition, String format, String ageGroup) {
        enterAuthorName(author);
        enterSubject(subject);
        selectEdition(edition);
        selectFormat(format);
        selectAgeGroup(ageGroup);
        clickSearch();
    }
}
