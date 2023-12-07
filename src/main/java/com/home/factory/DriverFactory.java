package com.home.factory;

import com.microsoft.playwright.*;

import com.home.utils.WebActions;
import java.util.Locale;

public class DriverFactory {
    public Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    public Page initDriver(String browserName) {
        BrowserType browserType = null;
        boolean headless = Boolean.valueOf(WebActions.getProperty("headless"));
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case "firefox":
                browserType = Playwright.create().firefox();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "chrome":
                browserType = Playwright.create().chromium();
                browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
                break;
            case "webkit":
                browserType = Playwright.create().webkit();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            default:
                throw new IllegalStateException("unknown browser type");
        }
        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        page = context.newPage();
        threadLocalDriver.set(page);
        threadLocalContext.set(context);
        return page;
    }

    public static synchronized Page getPage() {
        return threadLocalDriver.get();
    }

    public static synchronized BrowserContext getContext() {
        return threadLocalContext.get();
    }
}
