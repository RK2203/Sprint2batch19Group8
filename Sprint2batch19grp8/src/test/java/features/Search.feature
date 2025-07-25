
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
