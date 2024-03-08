Feature: Testing approved proposal as employee


  Scenario: Happy path for approved proposal status
    Given User navigates to employeeURL
    When User provides email_address and password to the loginPage
    When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
    And User Set Table length to "All" from drop down menu that is next to Export button on top of table
    Then User verify that status is 'Accepted' for approved proposals


#    Given User navigates to employeeURL and User log in with correct employee email and password
#    When User clicks on Sales then Proposals modules from left side navigation menu
#    And User Set Table length to "All" from drop down menu that is next to Export button on top of table
#    Then User verify that status is 'Accepted' for approved proposals