Feature: E-commerce Project Web Site Health Check

  Background: Navigate to URL
     Given User navigated to the home application url
     
     Scenario Outline: User is able to search multiple products
     When User Search for product "<ProductName>"
     Then Search result page are displayed
    
     Examples:
      |ProductName|
      |   laptop  | 
      |  earphone |
      |  computer | 
   
