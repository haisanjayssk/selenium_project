Feature: Validate Alternate Dynamic Table

  Scenario: Verify data in a sample table
    Given I navigate to the W3Schools table page
    When I extract data from the "HTML Table Example"
    Then the "Contact" column should contain "Maria Anders"
    And the total number of rows should be 7
