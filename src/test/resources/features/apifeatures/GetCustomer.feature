Feature: Customer API validation

  Scenario: API-Check for all current customers
    Given user have baseuri and endpoint "/customers"
    When the user sends the "GET" request
    Then user verifies status code is 200
    * verifies number of values is 5
    * verifies that the response contains the following user IDs: [2, 3, 4, 5, 9]
    * verifies that response is alphabetically ordered by company name