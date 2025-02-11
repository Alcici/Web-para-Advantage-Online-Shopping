package tests;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class TestSetup {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @Before
    public void setUp() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browser == null) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        if (page == null) {
            page = browser.newPage();
            page.navigate("https://www.advantageonlineshopping.com/#/search/?viewAll=computador");
        }
    }

    public static Page getPage() {
        return page;
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
        page = null;
    }
}