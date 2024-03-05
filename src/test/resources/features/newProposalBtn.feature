Feature: Verifying New Proposal button background color

  Scenario: Sign in to employee account and check "New proposal" button functionality

    Given User provides username and password to the loginPage
    When User clicks Sales Module Button and user clicks Proposals Module Button
    Then User validates that there a button New Proposal and background-color is 'rgba(37, 99, 235, 1)'