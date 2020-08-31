package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager implements Controller {

    private Browser browser = Browser.FIREFOX;
    private WebDriver driver;

    public Browser getBrowser() {
        return browser;
    }

    @Override
    public String getBrowserName() {
        return Browser.FIREFOX.name();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setupController() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        this.driver = new FirefoxDriver();
    }
}