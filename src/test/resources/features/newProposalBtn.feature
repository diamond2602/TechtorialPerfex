@regression
Feature: Verifying New Proposal button background color

  Scenario: Sign in to employee account and check "New proposal" button functionality
    And  User navigates to the "employee_url" url
    And User login as "employee"
    When User Clicks "Sales" Module from left side navigation menu and "Proposals" module
    Then User validates that there a button New Proposal and background-color is 'rgba(37, 99, 235, 1)'