@City
Feature: City module API Automation

  Scenario Outline: Verify User gets the Cityid from City list through API
    Given user adds the header to get the citylist
    When user add "stateId" as payload request body to get the CityList
    And user sends "POST" request to CityList endpoint 
    And user should verify the status code 200 from the response
    Then user verifies the response body matches the <CityName> and saves the <CityId>
