@State
Feature: State module API Automation

  Scenario Outline: Verify user gets the state id from the StateList through API
    Given user add headers to get the statelist
    When user sends "GET" request to stateList endpoint
    And user should verify the status code 200 from the response
    Then user verifies the statlist response message and matche <StateName> and saves the <stateId>
