Feature: Test JSON Placeholder API

  Scenario: Validate a GET request to fetch posts
    Given I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain "userId"
    And the response should contain "title"
