package pages;

import driver.BrowserManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TransactionPage extends BasePage {
    public TransactionPage(BrowserManager browserManager) {
        super(browserManager);
    }

    @FindBy(how = How.XPATH, using = "//div[text()='Transaction successful']")
    private WebElement lbl_transaction_success;

    @FindBy(how = How.XPATH, using = "//span[text()='Transaction failed']")
    private WebElement lbl_transaction_failed;

    @FindBy(how = How.CSS, using = ".button-main-content")
    private WebElement btn_retry;

    @FindBy(how = How.ID, using = "snap-midtrans")
    private WebElement frame_orderSummary;

    public boolean isTransactionCompleted() {
        fluentWait.until(driver -> driver.switchTo().frame(frame_orderSummary));
        return getElementVisibility(lbl_transaction_success).isDisplayed();
    }

    public boolean isTransactionDeclined() {
        fluentWait.until(driver -> driver.switchTo().frame(frame_orderSummary));
        return getElementVisibility(lbl_transaction_failed).isDisplayed();
    }

    public String getTransactionSuccessMessage() {
        return getElementVisibility(lbl_transaction_success).getText();
    }

    public boolean isTransactionSuccess() {
        try {
            return lbl_transaction_success.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTransactionFailedMessage() {
        return lbl_transaction_failed.getText();
    }

    public void perform_retry() {
        getElement(btn_retry).click();
    }
}