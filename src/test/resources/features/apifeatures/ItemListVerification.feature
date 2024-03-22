Feature: Verify Items Search API Endpoint

  Scenario: Verify items search endpoint
    Given user have base uri and endpoint "/items/search/"
    And user set the header "authtoken" and send "GET" request
    * verify that the response status code is 200
    * verify that the response contains 3 items
    * verify the item with ID 2 have the name "(10.00) Ethernet Cable"
