Feature: Dataflow Importer Installation

  Scenario: As a user, I need to install the Dataflow Importer
    Given I navigate to the login page
    Then I login with valid tapestry and tapestry123
    Then I navigate to available solutions
    And Show 100 rows
    Then Click on solution dataflow-importer version 1.0.1-kambol4
    Then Install Importer solution with name new-dataflow-importer
