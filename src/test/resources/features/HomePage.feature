@ui
Feature: Home Page Validation

 Scenario Outline: Validation  Header Links
     Given User navigated to the home application url
     Then User seen Below header <Links> are displayed
     Examples: 
     			 |Links|
           |hamburger menu|
           |amazone prime logo|
           |accounts and list link|
           |return and orders|
           |your prime link|
           |cart link|
 