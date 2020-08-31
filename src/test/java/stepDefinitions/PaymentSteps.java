package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PaymentPage;
import pages.TransactionPage;

public class PaymentSteps {

    private TransactionPage transactionPage;
    private PaymentPage paymentPage;

    public PaymentSteps(PaymentPage paymentPage, TransactionPage transactionPage) {
        this.paymentPage = paymentPage;
        this.transactionPage = transactionPage;
    }

    @Then("I enter {string}")
    public void i_enter(String otp) {
        paymentPage.completeTransaction(otp);
    }

    @When("I click on cancel button")
    public void i_click_on_cancel_button() {
        paymentPage.cancelTransaction();
    }

    @When("I click on retry button")
    public void i_click_on_retry_button() {
        transactionPage.perform_retry();
    }


    @Then("I should be able to see {string}")
    public void i_should_be_able_to_see(String message) {
        if (message.contains("Transaction failed")) {
            Assert.assertTrue("Transaction was not declined on clicking cancel button",
                    transactionPage.isTransactionDeclined());
            Assert.assertEquals(message,
                    transactionPage.getTransactionFailedMessage());
        } else {
            Assert.assertTrue("Transaction was not successful with correct card details",
                    transactionPage.isTransactionCompleted());
            Assert.assertEquals(message,
                    transactionPage.getTransactionSuccessMessage());
        }

    }

    @Then("I should not be able to see {string}")
    public void i_should_not_be_able_to_see(String string) {
        Assert.assertFalse("Transaction is successful with incorrect card details",
                transactionPage.isTransactionSuccess());
    }

}

