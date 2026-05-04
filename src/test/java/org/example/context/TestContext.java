package org.example.context;


import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class TestContext {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    // TODO: don't use static and use dependency injection for the Page object
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
    public static void createNewPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1000);
    }

    @After
    public static void closeBrowserContext(){
        context.close();
    }

    public static Page getPage(){
            return page;
        }
}
