package java.com.home.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public class DriverFactory {
    public Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    public Page initDriver(String browserName) {
        BrowserType browserType = null;
        boolean headless = Boolean.valueOf()
    }
}
