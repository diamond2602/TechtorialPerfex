Feature: Proposal Acceptance Workflow
  Background:
    Given the user navigates to the URL

  Scenario: Verify Proposal Acceptance Workflow

    And the user logs in with valid credentials
    Then the page title should be "Apple LLC"

    When the user clicks on the "Proposals" menu in the top navigation
    And the proposal with title "almaz_Proposal_Test_TC5" is in the list
    And the total for the proposal is "$300.30"
    And the user saves the proposal ID as "PRO-000069" and clicks on the proposal with Proposal # equal to saved proposal id
    Then the "PRO-000069" should match the value in the new page's "h4" element
    And the page title should be "almaz_Proposal_Test_TC5"
    And the first item in the table should be "Asus Monitor"
    And the second item in the table should be "Ethernet Cable"
    And the page should have an "Accept" button

    When the user clicks the "Accept" button
    And clicks the "Sign" button on the pop-up screen

    Then a red signature error message should be displayed stating "Please sign the document." under the signature box
    And the user draws a signature in the canvas and clicks the "Sign" button again

    Then a "Accepted" status label with a green background should appear next to the proposal ID
