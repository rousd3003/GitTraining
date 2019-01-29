package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        if (today.equals("Friday")) {
            return "TGIF";
        }
        return "Nope";
    }


}

public class Stepdefs {
    private String today;
    private Object actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_Sunday() throws Exception {
        today = "sunday";
    }

    @Given("^today is Saturday$")
    public void todayIsSaturday() throws Throwable {
        today = "saturday";
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() throws Exception {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) throws Exception {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("^today is Friday$")
    public void today_is_Friday() throws Exception {
        this.today = "Friday";
    }

    @Then("^I should be told \"TGIF$")
    public void i_should_be_told_TGIF() throws Exception {

    }
}