package pages;

import driver.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected String browserName;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;

    public BasePage(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
        this.browserName = browserManager.getBrowserName();
        this.wait = new WebDriverWait(driver, 10);
        fluentWait = new FluentWait<>(driver).
                withTimeout(4, TimeUnit.SECONDS).
                pollingEvery(250, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class);
        PageFactory.initElements(driver, this);
    }

    protected WebElement getElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement getElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElement(WebElement element) {
        return fluentWait.until(driver -> getElementVisibility(element));
    }
}