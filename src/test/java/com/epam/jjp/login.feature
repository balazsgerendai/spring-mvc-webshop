Feature: User tries to log in
 
Scenario: The user tries to log in with correct username and password
Given a User is on the "http://localhost:8080/login" page
When a User enters the username "balazs"
And password of "1234"
And a User click on the submit button
Then the user should be redirected to the "http://localhost:8080/"

Scenario: The user tries to log in with incorrect username and password
Given a User is on the "http://localhost:8080/login" page
When a User enters the username "wrongUsername"
And password of "1234124"
And a User click on the submit button
Then the user should be redirected to the "http://localhost:8080/loginFailed.html"
