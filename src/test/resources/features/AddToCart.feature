
 Feature: User is clicked on add to cart button
@wip
  Scenario: User is click on the Product and check the Product Details and click on add to cart
    Given User navigated to the home application url
    And User Search for product "earphone"
    When User click on any product
    And Product Description is displayed in new tab
    Then User validate price of the product
    And User is click on Add to cart
    And again validate price of product and compare with privious price
   
