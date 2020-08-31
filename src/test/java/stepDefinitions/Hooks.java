package stepDefinitions;


import driver.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    BrowserManager browserManager;

    public Hooks(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @Before
    public void setup() {
        browserManager.setupController();
        browserManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        browserManager.getDriver().manage().window().maximize();
    }

    @After
    public void teardown() {
        browserManager.teardownController();
    }
}
