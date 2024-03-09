@regression
Feature: Verifying submodules and their quantity and order

  Background:
    And  User navigates to the "employee_url" url
    And User login as "employee"

    Scenario:
      And the employee clicks on Sales button in navigation menu from lest side
      And Employee can see all submodules and check their quantity
      Then Employee can verify the right order of given submodules