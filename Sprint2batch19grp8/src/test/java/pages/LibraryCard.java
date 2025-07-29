package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LibraryCard {

    WebDriver driver;

    public LibraryCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---------------------- Input Fields ----------------------

    @FindBy(id = "first")
    private WebElement firstName;

    @FindBy(id = "last")
    private WebElement lastName;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "school")
    private WebElement school;

    @FindBy(id = "company")
    private WebElement company;

    // ---------------------- Role Radio Buttons ----------------------

    @FindBy(id = "work_0") // Student
    private WebElement studentRadio;

    @FindBy(id = "work_1") // Employee
    private WebElement employeeRadio;

    // ---------------------- Dropdown ----------------------

    @FindBy(id = "action")
    private WebElement actionDropdown;

    // ---------------------- Submit Button ----------------------

    @FindBy(id = "libraryCardSubmit")
    private WebElement submitButton;

    // ---------------------- Error Messages ----------------------

    @FindBy(id = "firstnameError")
    private WebElement firstNameError;

    @FindBy(id = "lastnameError")
    private WebElement lastNameError;

    @FindBy(id = "ageError")
    private WebElement ageError;

    @FindBy(id = "workError")
    private WebElement workError;

    @FindBy(id = "actionError")
    private WebElement actionError;

    // ---------------------- Interaction Methods ----------------------

    public void enterFirstName(String fname) {
        firstName.clear();
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.clear();
        lastName.sendKeys(lname);
    }

    public void enterAge(String userAge) {
        age.clear();
        age.sendKeys(userAge);
    }

    public void enterEmail(String userEmail) {
        email.clear();
        email.sendKeys(userEmail);
    }

    public void enterPhone(String userPhone) {
        phone.clear();
        phone.sendKeys(userPhone);
    }

    public void enterCompany(String companyName) {
        company.clear();
        company.sendKeys(companyName);
    }

    public void enterSchool(String schoolName) {
        school.clear();
        school.sendKeys(schoolName);
    }

    public void selectStudent() {
        studentRadio.click();
    }

    public void selectEmployee() {
        employeeRadio.click();
    }

    public void selectRole(String role) {
        if (role.equalsIgnoreCase("Student")) {
            selectStudent();
        } else if (role.equalsIgnoreCase("Employee")) {
            selectEmployee();
        }
    }

    public void selectAction(String value) {
        new Select(actionDropdown).selectByVisibleText(value); // e.g., "Apply New Card"
    }

    public void clickSubmit() {
        submitButton.click();
    }

    // ---------------------- Error Getters ----------------------

    public String getFirstNameError() {
        return firstNameError.getText().trim();
    }

    public String getLastNameError() {
        return lastNameError.getText().trim();
    }

    public String getAgeError() {
        return ageError.getText().trim();
    }

    public String getWorkError() {
        return workError.getText().trim();
    }

    public String getActionError() {
        return actionError.getText().trim();
    }
}
