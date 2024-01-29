@SearchProduct
Feature: Product search API module

  Scenario Outline: Verify search product to the through API automation
    Given user added headers to search the product
    When user sends <ProductName> as payload to the search the product
    And user sends "POST" request to SearchProduct endpoint
    And user should verify the status code 200 from the response
    Then user verifies the response body success message as <OK> and <Product Id>, <CatagoryId>
