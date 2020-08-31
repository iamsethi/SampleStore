package driver;

import org.openqa.selenium.WebDriver;

interface Controller {
    String getBrowserName();

    Browser getBrowser();

    WebDriver getDriver();

    void setDriver(WebDriver driver);

    void setupController();

    default void teardownController() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}