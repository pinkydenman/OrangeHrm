package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.junit.jupiter.api.Assertions;

public class DashboardPage {
    private final Page page;

    public DashboardPage(Page page) {
        this.page = page;
    }

    public void goToLeavePage() {
        page.locator("a.oxd-main-menu-item:has-text('Leave')").click();
        Locator leaveListLink = page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Leave List")
        );
        leaveListLink.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        Assertions.assertTrue(leaveListLink.isVisible());
    }

}
