package stepDefinitions;

import io.cucumber.java.en.When;
import pages.OrderSummaryPage;

public class OrderSummarySteps {

    OrderSummaryPage orderSummaryPage;

    public OrderSummarySteps(OrderSummaryPage orderSummaryPage) {
        this.orderSummaryPage = orderSummaryPage;
    }

    @When("I click on continue button")
    public void i_click_on_continue_button() {
        orderSummaryPage.review_order_summary();
    }

}

