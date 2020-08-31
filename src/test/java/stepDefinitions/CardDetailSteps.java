package stepDefinitions;

import io.cucumber.java.en.When;
import pages.CardDetailPage;

public class CardDetailSteps {

    CardDetailPage cardDetailPage;

    public CardDetailSteps(CardDetailPage cardDetailPage) {
        this.cardDetailPage = cardDetailPage;
    }

    @When("I fill the details with {string} , {string}, {string}")
    public void i_fill_the_details_with_and(String cardnumber, String expiry_date, String cvv_number) {
        cardDetailPage.payWithCard();
        cardDetailPage.fillCardDetails(cardnumber, expiry_date, cvv_number);
    }

    @When("I click on pay now button")
    public void i_click_on_pay_now_button() {
        cardDetailPage.payNow();
    }
}