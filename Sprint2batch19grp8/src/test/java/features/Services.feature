Feature: Services Form - Email Submission

  Background:
    Given the user is on the Services form page

  Scenario: Submit valid Email form
    When the user selects "Email" option
    And the user enters "alice@mail.com" in the "From" field
    And the user enters "librarian@library.com" in the "To" field
    And the user enters "Need access to digital archives" in the "Query" field
    And the user clicks "Submit"
    Then the message "Mail Sent Successfully" should appear

  Scenario: Submit Email with missing fields
    When the user selects "Email" option
    And the user leaves "From" and "Query" fields blank
    And the user clicks "Submit"
    Then the error message "Please enter a valid email and query" should be shown

  Scenario: Submit Email with invalid email format
    When the user selects "Email" option
    And the user enters "test@@mail" in the "From" field
    And the user enters "Book access issue" in the "Query" field
    And the user clicks "Submit"
    Then the error message "Invalid email format" should be displayed below the From field

  Scenario: Verify that the To field is auto-filled
    When the user selects "Email" option
    Then the "To" field should be auto-filled with "librarian@domain.com"

  