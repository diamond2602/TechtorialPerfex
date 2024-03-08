Feature: Testing Create New Proposal for a customer Functionality

#  Scenario: Create a new proposal with specified details
#    When User provides email_address and password to the loginPage
#    When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
#    And user clicks New Proposal button from the top
#    And user fills the Subject line with 'almaz_Proposal_Test_TC5'
#    And user selects "Customer" from the Related dropdown
#    And user types "Apple" into the Customer filter and selects "Apple LLC" from the results
#    And user types "Apple" into the Project filter and selects "#1 - Apple Project - Apple LLC"
#    And user clicks Add Item button and selects "(253.00) Asus Monitor" from the dropdown list
#    And user clicks the blue check button to add the item
#    And user clicks Add Item button and selects "(10.00) Ethernet Cable" from the dropdown list
#    And user changes the quantity of Ethernet Cable to "2"
#    And user clicks the blue check button to add the item
#    Then user verifies that the Total is "$300.30"
#    And user clicks Save & Send button
#    Then Find created Proposal and verify that its status is "Sent"


  Scenario: Create a new proposal with specified details datatable
    When User provides email_address and password to the loginPage
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