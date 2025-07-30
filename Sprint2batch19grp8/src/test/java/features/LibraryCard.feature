Feature: Library Card Sign-Up Validation

  As a new user
  I want to apply for a library card
  So that I can access library facilities based on my role

  Background:
    Given the user is on the Library Card page

  Scenario: Display error when First Name is missing
    When the user leaves the First Name field blank
    And the user enters "Sharma" in the Last Name field
    And the user enters "25" in the Age field
    And the user enters "test@mail.com" in the Email field
    And the user enters "9876543210" in the Phone field
    And the user selects Student from the Role radio options
    And the user enters "ABC School" in the School field
    And the user selects "Apply New Card" from the Action dropdown
    And the user clicks on the Apply New Card button
    Then an inline error message should be displayed for First Name as "First Name is required"

  Scenario: Submit application successfully as Employee
    When the user enters "Raj" in the First Name field
    And the user enters "Mehta" in the Last Name field
    And the user enters "30" in the Age field
    And the user enters "raj@mail.com" in the Email field
    And the user enters "1234567890" in the Phone field
    And the user selects Employee from the Role radio options
    And the user enters "CTS" in the Company field
    And the user selects "Apply New Card" from the Action dropdown
    And the user clicks on the Apply New Card button
    Then the form should be submitted successfully
    And a library card should be displayed with name "Raj Mehta"

  Scenario: Display error when Age is missing
    When the user enters "Alok" in the First Name field
    And the user enters "Tiwari" in the Last Name field
    And the user leaves the Age field blank
    And the user enters "alok@mail.com" in the Email field
    And the user enters "9876501234" in the Phone field
    And the user selects Student from the Role radio options
    And the user enters "XYZ School" in the School field
    And the user selects "Apply New Card" from the Action dropdown
    And the user clicks on the Apply New Card button
    Then an inline error message should be displayed for Age as "Age is required"
