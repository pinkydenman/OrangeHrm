package org.example.stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import org.example.context.TestContext;
import org.example.pages.LoginPage;

public class LoginSteps {

    private static final String url = "https://opensource-demo.orangehrmlive.com/";
    private static final String username = "Admin";
    private static final String password = "admin123";


    @Given("Alice logs into OrangeHR")
    public void alice_logs_into_orange_hr() {
        LoginPage loginPage = new LoginPage(TestContext.getPage());
        loginPage.login(url, username, password);
    }
}
