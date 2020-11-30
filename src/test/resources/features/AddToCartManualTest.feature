
Feature: User is clicked on add to cart button
Background: Navigate to URL
     Given User navigated to the home application url
     
   Scenario Outline: User is click on the multiple Product and check the Product Details and click on add to cart
    When User Search for product "<ProductName>"
    And User click on any product
    And Product Description is displayed in new tab
    Then User is click on Add to cart

    Examples:
     |  ProductName |
     |  earphone    |
     |  dell        |
     |  laptop      |
     

  
    
    
 
    
    