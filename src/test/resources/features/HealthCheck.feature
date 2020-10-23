@ui @healthcheck
Feature: E-commerce Project Web Site Health Check

  Background: Navigate to URL
     Given User navigated to the home application url

  #Scenario: User is able to Open the browser, navigate to the URL and Search for Product
  
     # When User Search for product "Laptop"
     # Then Search Result page is displayed
    
  #Scenario: User is click on the Product and Check the Product Details
   
     # When User Search for product "earphone"
     # And User click on any product
     # Then Product Description is displayed in new tab 
  
  Scenario Outline: User is able to search multiple products
    When User Search for product "<ProductName>"
    Then Search result page are displayed
    
    Examples:
     |ProductName|
     |   laptop  | 
     |  earphone |
     |  computer | 
   
    
  
    