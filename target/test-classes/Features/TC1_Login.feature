@Login
Feature: Login module API Automation

  Scenario Outline: Get user logtoken form login endpoint
    Given user add header
    When user add basic authentication "<userName>", "<password>" to login
    And user sends "POST" request to login endpoint
    And user should verify the status code 200 from the response
    Then user should verifies the logged in user firstName "Darrien" and saves the log token

    Examples: 
      | userName             | password   |
      | dassdowney@gmail.com | Testing@12 |