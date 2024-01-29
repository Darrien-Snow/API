@AddAddress
Feature: Add Address module API Automation

  Scenario Outline: Verify adds new address to the application through API
    Given user adds headers and passes <Authorization>,<Bearer >+<logtoken> as one of header to addAddress
    When user adds <First Name>,<Last Name>,<Mobile No>, <stateId>,<cityId>,<countryId>,<Zip code>, <Address>, <Address Type> as payload to the add the userAddress
    And user sends "POST" request to <AddAddress> endpoint
    And user should verify the status code 200 from the response
    Then user verifies the response body matched the message "Address added successfully" saves the<addressId>
