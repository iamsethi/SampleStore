package pages;

import driver.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public HomePage(BrowserManager browserManager) {
        super(browserManager);
    }

    @FindBy(how = How.CSS, using = ".btn.buy")
    private WebElement btn_buyNow;

    public void navigateToStore(String store_address) {
        driver.get(store_address);
    }

    public void buyNow() {
       getElement(btn_buyNow).click();
    }
}