package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {

    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("I am on {string} website")
    public void i_am_on_website(String website) {
        homePage.navigateToStore(website);
    }

    @When("I click on buy now button")
    public void i_click_on_buy_now_button() {
        homePage.buyNow();
    }
}