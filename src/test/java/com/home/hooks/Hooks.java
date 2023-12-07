package com.home.hooks;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.home.factory.DriverFactory;

import com.home.utils.WebActions;
import java.nio.file.Paths;

public class Hooks {
    public DriverFactory driverFactory;
    public Page page;

    @Before
    public void launchBrowser() {
        String browserName = WebActions.getProperty("browser");
        driverFactory = new DriverFactory();
        page = driverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        page.close();
    }

    @After(order = 1)
    public void takeScreenShotAndLogs(Scenario scenario) {
        if (scenario.isFailed()) {
            String screen = scenario.getName().replace("", "_");
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath, "image/png", screen);
            DriverFactory.context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("target/" + screen + ".zip")));
        }
    }
}
