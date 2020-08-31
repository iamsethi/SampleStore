package pages;

import driver.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage {

    public CartPage(BrowserManager browserManager) {
        super(browserManager);
    }

    @FindBy(how = How.CSS, using = ".cart-checkout")
    private WebElement btn_ContinueToCheckout;

    public void perform_checkout() {
        getElement(btn_ContinueToCheckout).click();
    }

}