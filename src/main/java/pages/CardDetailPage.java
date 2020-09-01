package pages;

import driver.BrowserManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CardDetailPage extends BasePage {
    public CardDetailPage(BrowserManager browserManager) {
        super(browserManager);
    }

    @FindBy(how = How.CSS, using = ".list.with-promo")
    private WebElement btn_pay_by_credit_card;

    @FindBy(how = How.NAME, using = "cardnumber")
    private WebElement txt_card_number;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='MM / YY']")
    private WebElement txt_expiry_date;

    @FindBy(how = How.XPATH, using = "//input[@inputmode='numeric']")
    private WebElement txt_cvv;

    @FindBy(how = How.CSS, using = ".button-main-content")
    private WebElement btn_pay_now;

    @FindBy(how = How.CSS, using = ".notice.success")
    private WebElement lbl_notice_success;

    public void payWithCard() {
        getElement(btn_pay_by_credit_card).click();
    }

    public void fillCardDetails(String cardnumber, String expiry_date, String cvv_number) {
        forceWait(2);
        getElementVisibility(lbl_notice_success);
        getElement(txt_card_number).sendKeys(cardnumber);
        getElement(txt_card_number).sendKeys(Keys.TAB);
        getElement(txt_expiry_date).sendKeys(expiry_date);
        getElement(txt_expiry_date).sendKeys(Keys.TAB);
        getElement(txt_cvv).sendKeys(cvv_number);
    }

    public void payNow() {
        getElement(btn_pay_now).click();
    }
}