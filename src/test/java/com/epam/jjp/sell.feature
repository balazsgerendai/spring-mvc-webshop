Feature: User sells a product
 
Scenario: The user puts up an item for sale
Given a User is logged in with "balazs" and password of "1234" on the page "http://localhost:8080/"
And User is on the "http://localhost:8080/sell" page
Given User fills in the form:
    | username        | New Test item 		|
    | description     | Selenium Test Item  |
    | price   		  | 1235  			    |
When User click on the submit button
Then the User should receive a Save successfull. message
