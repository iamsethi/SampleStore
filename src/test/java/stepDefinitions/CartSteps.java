package stepDefinitions;

import io.cucumber.java.en.When;
import pages.CartPage;

public class CartSteps {

    CartPage cartPage;

    public CartSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @When("I click on checkout button")
    public void i_click_on_checkout_button() {
        cartPage.perform_checkout();
    }

}

