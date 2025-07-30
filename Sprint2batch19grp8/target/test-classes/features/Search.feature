Feature: Advanced Library Book Search

  Scenario: Search books using all advanced search fields
    Given the user is on the Advanced Search page
    When the user enters author name as "Rabindranath Tagore"
    And the user enters subject as "Poetry"
    And the user selects edition as "Edition 2"
    And the user selects format as "E_Books"
    And the user selects age group as "Teen"
    And the user clicks on the search button
    Then the search results should be displayed

  Scenario: Verify mandatory validation for Author Name
    Given the user is on the Advanced Search page
    When the user enters author name as ""
    And the user enters subject as "Science"
    And the user selects edition as "Edition 3"
    And the user selects format as "E_Books"
    And the user selects age group as "Teen"
    And the user clicks on the search button
    Then an inline error should be shown with message "Please Enter the Author Name"

  Scenario: Verify validation for missing Age Group
    Given the user is on the Advanced Search page
    When the user enters author name as "Agatha Christie"
    And the user enters subject as "Mystery"
    And the user selects edition as "Edition 2"
    And the user selects format as "Magazines"
    And the user does not select any age group
    And the user clicks on the search button
    Then an inline error should be shown with message of age "Please Select AgeGroup"

  Scenario: Verify dropdown behavior for Book Format
    Given the user is on the Advanced Search page
    When the user checks the available options in the Book Format dropdown
    Then the Book Format dropdown should contain the following options:
      | Select        |
      | E_Books       |
      | E_AudioBooks  |
      | Magazines     |
      | NewsPaper     |
      | Encyclopedias |

  Scenario: Verify error message when Edition is left as default
   Given the user is on the Advanced Search page
   When the user enters author name as "Leo Tolstoy"
   And the user enters subject as "History"
   And the user selects format as "E_Books"
   And the user selects age group as "Kids"
   And the user leaves edition as default
   And the user clicks on the search button
   Then an inline error should be shown with message of "Please Select Edition"

