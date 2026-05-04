package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private final Page page;
    public LoginPage(Page page){
        this.page = page;
    }
    public void login(String url, String username, String password) {
        page.navigate(url);
        page.getByPlaceholder("Username").fill(username);
        page.getByPlaceholder("Password").fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
