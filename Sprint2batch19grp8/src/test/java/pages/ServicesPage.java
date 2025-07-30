package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ServicesPage {

    WebDriver driver;
    WebDriverWait wait;

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       
    }

    // Medium radio buttons
    @FindBy(id = "medium_email")
    private WebElement emailRadioButton;

    @FindBy(id = "medium_call")
    private WebElement callRadioButton;

    @FindBy(id = "medium_chat")
    private WebElement chatRadioButton;

    // Common Submit Button
    @FindBy(id = "QuerySubmit")
    private WebElement submitButton;

    // ------------------ Email Section ------------------
    @FindBy(id = "fromEmail")
    private WebElement fromEmailInput;

    @FindBy(id = "fromemailError")
    private WebElement fromEmailError;

    @FindBy(id = "toEmail")
    private WebElement toEmailInput;

    @FindBy(id = "queryemail")
    private WebElement emailQueryInput;

    @FindBy(id = "queryemailError")
    private WebElement queryEmailError;

    @FindBy(id = "mediummailoutput")
    private WebElement emailSuccessMessage;
    
    public WebElement getFromEmailInput() {
        return fromEmailInput;
    }

    public WebElement getEmailQueryInput() {
        return emailQueryInput;
    }
    public WebElement getToEmailInput() {
        return toEmailInput;
    }



    // ------------------ Chat Section ------------------
    @FindBy(id = "chatname")
    private WebElement chatNameInput;

    @FindBy(id = "chatnameError")
    private WebElement chatNameError;

    @FindBy(id = "yourphone")
    private WebElement phoneInput;

    @FindBy(id = "yourphoneError")
    private WebElement phoneError;

    @FindBy(id = "libraryphone")
    private WebElement libraryPhoneInput;

    @FindBy(id = "querychat")
    private WebElement chatQueryInput;

    @FindBy(id = "querychatError")
    private WebElement queryChatError;

    @FindBy(id = "mediumchatoutput")
    private WebElement chatSuccessMessage;

    // ------------------ Actions ------------------

    public void selectEmailMedium() {
        emailRadioButton.click();
    }

    public void selectCallMedium() {
        callRadioButton.click();
    }

    public void selectChatMedium() {
        chatRadioButton.click();
    }

    public void enterEmailDetails(String from, String query) {
        fromEmailInput.clear();
        fromEmailInput.sendKeys(from);
        emailQueryInput.clear();
        emailQueryInput.sendKeys(query);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getEmailSuccessMessage() {

        return emailSuccessMessage.getText();
    }

    public String getEmailFromError() {
        return fromEmailError.getText();
    }

    public String getEmailQueryError() {
        return queryEmailError.getText();
    }

    public String getToEmailValue() {
        return toEmailInput.getAttribute("value");
    }

    public boolean isToEmailDisabled() {
        return !toEmailInput.isEnabled();
    }

    public void enterChatDetails(String name, String phone, String query) {
        chatNameInput.clear();
        chatNameInput.sendKeys(name);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        chatQueryInput.clear();
        chatQueryInput.sendKeys(query);
    }

    public String getChatSuccessMessage() {
        
        return chatSuccessMessage.getText();
    }

    public String getPhoneValidationMessage() {
        return phoneError.getText();
    }

    public boolean isLibraryFieldDisabled() {
        return !libraryPhoneInput.isEnabled();
    }

    public String getLibraryFieldValue() {
        return libraryPhoneInput.getAttribute("value");
    }
}
