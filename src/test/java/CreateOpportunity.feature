Feature: Create Salesforce Opportunity

  Scenario: Create a new Opportunity in Salesforce
    Given I am logged into Salesforce with username "gokul.sekar@testleaf.com" and password "Leaf$321"
    When I create a new opportunity with name "Salesforce Automation"
    And I set the close date to today
    And I select "Needs Analysis" as the stage
    Then the opportunity should be created successfully