@wip5
 Feature: User is click on Add To Wish List 

  Scenario: User is click on the product and check the product details and click on add to wish list
    Given User navigated to the home application url
    And User search for tha product "earphone"
    When User click on any product
    Then Product Description is displayed in new tab
    And User is click on Add to wish list button
    
  