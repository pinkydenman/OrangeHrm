package org.example.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class TestContext {
    private BrowserContext browserContext;
    private Page page;

    public BrowserContext getBrowserContext() {
        return browserContext;
    }

    public void setBrowserContext(BrowserContext browserContext) {
        this.browserContext = browserContext;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
