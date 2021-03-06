package pages;

import driver.BrowserManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage extends BasePage {
    public PaymentPage(BrowserManager browserManager) {
        super(browserManager);
        getElementVisibility(bank_page);
    }

    @FindBy(how = How.CSS, using = ".main-container")
    private WebElement bank_page;

    @FindBy(how = How.ID, using = "PaRes")
    private WebElement txt_password;

    @FindBy(how = How.NAME, using = "ok")
    private WebElement btn_submit;

    @FindBy(how = How.NAME, using = "cancel")
    private WebElement btn_cancel;

    @FindBy(how = How.NAME, using = "resend")
    private WebElement btn_resend;

    public void completeTransaction(String otp) {
        driver.switchTo().frame(0);
        waitForElement(txt_password);
        txt_password.sendKeys(otp);
        getElement(btn_submit).click();
        driver.switchTo().defaultContent();
    }

    public void cancelTransaction() {
        driver.switchTo().frame(0);
        waitForElement(txt_password);
        txt_password.sendKeys("111111");
        txt_password.sendKeys(Keys.TAB);
        getElement(btn_cancel).click();
        driver.switchTo().defaultContent();
    }
}