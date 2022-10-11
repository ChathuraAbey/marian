Feature: User Login
  Scenario: User giving valid creditials
    Given The user is on Login Page
    When The user enters valid creditials
    Then The user should get the bearer token