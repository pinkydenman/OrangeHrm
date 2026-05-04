package org.example.stepdefs;

import io.cucumber.java.en.When;
import org.example.context.TestContext;
import org.example.pages.DashboardPage;


public class DashboardPageSteps {
    DashboardPage dashboardPage = new DashboardPage(TestContext.getPage());

    @When("Alice navigates to Leave")
    public void alice_navigates_to_leave() {
        //ToDo: may need to accomiodate steps to click on menu based on screensize
        dashboardPage.goToLeavePage();
    }
}
