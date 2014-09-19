Feature: User buys a product
 
Scenario: The users buys a product and has enough money for it
Given a User is logged in with "balazs" and password of "1234" on the page "http://localhost:8080/"
And User is on the "http://localhost:8080/sales/pages/1" page
When User clicks on a buy button
Then the User should get an alert window with successful purchase
