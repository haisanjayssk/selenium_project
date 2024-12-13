Feature: Login functionality

  Scenario Outline: Validate login scenarios
    Given I navigate to the login page
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    Then I should see "<expectedOutcome>"

  Examples:
    | username     | password             | expectedOutcome                |
    | tomsmith     | SuperSecretPassword! | Dashboard page is displayed    |
    | tomsmith     | wrongPassword        | Your password is invalid!      |
    | wrongUser    | SuperSecretPassword! | Your username is invalid!      |
    |              |                      | Your username is invalid!      |
