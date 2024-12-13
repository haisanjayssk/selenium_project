Feature: Cascading dropdown functionality

  Scenario: Select parent and validate child dropdown
    Given I navigate to the cascading dropdown test page
    When I select "Fruits" from the parent dropdown
    Then I should see "Apple" in the child dropdown

  Scenario: Select another parent option and verify child
    Given I navigate to the cascading dropdown test page
    When I select "Vegetables" from the parent dropdown
    Then I should see "Carrot" in the child dropdown
