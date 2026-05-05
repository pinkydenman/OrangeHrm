package org.example.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    private static Playwright playwright;
    private static Browser browser;

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @BeforeAll
    public static void setupPlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    public static void closePlaywright(){
        browser.close();
        playwright.close();
    }

    @Before
    public void createNewPage() {
        testContext.setBrowserContext(browser.newContext());
        testContext.setPage(testContext.getBrowserContext().newPage());
        testContext.getPage().setViewportSize(1920, 1000);
    }

    @After
    public void closeBrowserContext(){
        testContext.getBrowserContext().close();
    }
}
