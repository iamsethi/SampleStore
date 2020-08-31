package driver;

import org.openqa.selenium.WebDriver;

public class BrowserManager implements Controller {

    private final Controller controller;

    public BrowserManager() {
        if (System.getProperty("browser") == null) {
            this.controller = new ChromeManager();
        } else if ("firefox".equalsIgnoreCase(System.getProperty("browser").toLowerCase())) {
            this.controller = new FirefoxManager();
        } else {
            this.controller = new ChromeManager();
        }
    }

    @Override
    public WebDriver getDriver() {
        return controller.getDriver();
    }

    @Override
    public void setDriver(WebDriver driver) {
    }

    @Override
    public void setupController() {
        controller.setupController();
    }

    @Override
    public String getBrowserName() {
        return controller.getBrowserName();
    }

    @Override
    public Browser getBrowser() {
        return controller.getBrowser();
    }
}