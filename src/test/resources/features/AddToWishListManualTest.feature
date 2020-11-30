Feature: User is clicked on add to Wish List 
 Background: Navigate to URL
     Given User navigated to the home application url
     
   Scenario Outline: User is click on the multiple Product and check the Product Details and click on add to Wish List
    When User Search for product "<ProductName>"
    And User click on any product
    And Product Description is displayed in new tab
    Then User is click on Add to Wish List 

    Examples:
     |  ProductName |
     |  earphone    |
     |  dell        |
     |  laptop      |