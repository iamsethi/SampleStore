package pages;

import driver.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderSummaryPage extends BasePage {
    public OrderSummaryPage(BrowserManager browserManager) {
        super(browserManager);
    }

    @FindBy(how = How.ID, using = "snap-midtrans")
    private WebElement frame_orderSummary;

    @FindBy(how = How.CSS, using = ".button-main-content")
    private WebElement btn_continue;

    public void review_order_summary() {
        driver.switchTo().frame(frame_orderSummary);
        getElement(btn_continue).click();
    }
}