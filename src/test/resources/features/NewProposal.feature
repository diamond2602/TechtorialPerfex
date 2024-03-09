@regression
Feature: Testing Create New Proposal for a customer Functionality


  Scenario: Create a new proposal with specified details datatable
    And  User navigates to the "employee_url" url
    And User login as "employee"
    When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
    And user creates new proposal with following data
      | subject        | almaz_Proposal_Test_TC5        |
      | related        | Customer                       |
      | customerSearch | Apple                          |
      | customer       | Apple LLC                      |
      | projectSearch  | Apple                          |
      | project        | #1 - Apple Project - Apple LLC |
      | itemSelect1    | (253.00) Asus Monitor          |
      | itemSelect2    | (10.00) Ethernet Cable         |
      | quantity       | 2                              |
      | total          | $300.30                        |
      | status         | Sent                           |
    Then Find created Proposal and verify that its status is "Sent"