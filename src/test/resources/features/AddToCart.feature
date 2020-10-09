
 Feature: User is clicked on add to cart button
@wip
  Scenario: User is click on the Product and check the Product Details and click on add to cart
    Given User navigated to the home application url
    And User Search for product "earphone"
    When User click on any product
    Then Product Description is displayed in new tab
    And User is click on Add to cart
   
