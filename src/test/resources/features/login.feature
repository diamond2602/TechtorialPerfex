@regression
Feature: Testing the Login Functionality of Techtorial CRM Website

  Background: Validates title and visibility of log_in
    And  User navigates to the "employee_url" url
    And User validates the Log In is visible on the page

  Scenario: Happy Path Login Functionality(Positive) for Techtorial CRM
    And User validates the title is 'Techtorial CRM - Login' from LoginPage
    And User login as "employee"
    Then User validates the title 'Dashboard' from MainPage


  Scenario: Negative Login Functionality(Incorrect email and password) for Techtorial CRM
    When User provides 'crm123@gmail.com' and '123456' to the loginPage
    Then User validates the title 'Invalid email or password' and 'rgba(185, 28, 28, 1)' from loginPage

#  navigate to url: Techtorial CRM - Login
#  Verify the title is "Techtorial CRM - Login"
#  Verify "Log In" is visiable on the page
#  Enter correct employee email and password
#  Click login button
#  Verify title is "Dashboard"

#  navigate to url: Techtorial CRM - Login
#  Verify the title is "techtorial"
#  Verify "Log In" is visiable on the page
#  Enter incorrect employee email and password
#  Click login button
#  Verify error message is displayed "Invalid email or password" in red color.
