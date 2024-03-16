 Feature: Testing if user can add comment to proposal and convert it to invoice


   Scenario: Create a new proposal with specified details datatable
     And  User navigates to the "employee_url" url
     And User login as "employee"
     When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
     And user creates new proposal with following data
       | subject        | cristian85_Proposal_Test_TC7        |
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

   Scenario: Verify Proposal Acceptance Workflow
     And  User navigates to the "customer_url" url
     And User login as "customer"
     Then the page title should be "Apple LLC"
     When the user clicks on the "Proposals" menu in the top navigation
     And the proposal with title "cristian85_Proposal_Test_TC7" is in the list
     And the total for the proposal is "$300.30"
     And the user saves the proposal ID as "cristian85_Proposal_Test_TC7" and clicks on the proposal with Proposal # equal to saved proposal id
     Then the proposal should match the value in the new page h4 element
     And the page title should be "cristian85_Proposal_Test_TC7"
     And the first item in the table should be "Asus Monitor"
     And the second item in the table should be "Ethernet Cable"
     And the page should have an "Accept" button
     When the user clicks the "Accept" button
     And clicks the "Sign" button on the pop-up screen
     Then a red signature error message should be displayed stating "Please sign the document." under the signature box
     And the user draws a signature in the canvas and clicks the "Sign" button again
     Then a "Accepted" status label with a green background should appear next to the proposal ID

   Scenario: Happy path for approved proposal status
     And  User navigates to the "employee_url" url
     When User login as "employee"
     When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
     And User Set Table length to "All" from drop down menu that is next to Export button on top of table
     Then User verify that status for proposal "cristian85_Proposal_Test_TC7" is "Accepted"

    Scenario: Adding the comment to existing proposal and converting it to Invoice
      And  User navigates to the "employee_url" url
      When User login as "employee"
      When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
      And User searches for proposal "cristian85_Proposal_Test_TC7" from search input box
      And User Verify that listed Proposal Subject is "cristian85_Proposal_Test_TC7", Project name is "Apple Project" and Status is "Accepted"
      And User clicks on the associated proposal id from Proposal # column
      And User clicks Comments tab and Add comment as "cristian85_Proposal_Test_TC7 is accepted for invoice"
      And User Verify that proposal comment "cristian85_Proposal_Test_TC7 is accepted for invoice" was added and that next to Comments tab there is "1" badge for total comment
      And User Click Convert button and Select Invoice from drop down menu
      Then User Verify that Customer is "Apple LLC" as default
      And Scroll down page and click Save button.
      And User Verify that there is red "Unpaid" label next to record header
      And User Verify that record header that starts with "INV-" same number with Invoice Number section in the form

   Scenario: Delete last added proposal
     And  User navigates to the "employee_url" url
     When User login as "employee"
     When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
     And User Set Table length to "All" from drop down menu that is next to Export button on top of table
     Then User verify that status for proposal "cristian85_Proposal_Test_TC7" is "Accepted"
     And User clicks on More button, then Delete and press click Ok on the alert






