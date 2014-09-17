package com.epam.jjp;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


public class HomeTest {

    @Given("^a User has no money in their account$")
    public void a_User_has_no_money_in_their_current_account() {
        // Express the Regexp above with the code you wish you had
    }
 
    @When("^£(\\d+) is deposited in to the account$")
    public void £_is_deposited_in_to_the_account(int arg1) {
        System.out.println(arg1);
    }
 
    @Then("^the balance should be £(\\d+)$")
    public void the_balance_should_be_£(int arg1) {
        // Express the Regexp above with the code you wish you had
    }
}
