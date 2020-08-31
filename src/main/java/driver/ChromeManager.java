package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager implements Controller {

    private Browser browser = Browser.CHROME;
    private WebDriver driver;

    public Browser getBrowser() {
        return browser;
    }

    @Override
    public String getBrowserName() {
        return Browser.CHROME.name();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setupController() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        this.driver = new ChromeDriver();
    }
}