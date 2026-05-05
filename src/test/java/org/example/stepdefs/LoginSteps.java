package org.example.stepdefs;

import io.cucumber.java.en.Given;
import org.example.config.ConfigManager;
import org.example.context.TestContext;
import org.example.pages.LoginPage;

public class LoginSteps {

    private static final String url = ConfigManager.getUrl();
    private static final String username = ConfigManager.getUsername();
    private static final String password = ConfigManager.getPassword();

    private final TestContext testContext;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("Alice logs into OrangeHR")
    public void alice_logs_into_orange_hr() {
        LoginPage loginPage = new LoginPage(testContext.getPage());
        loginPage.login(url, username, password);
    }
}
