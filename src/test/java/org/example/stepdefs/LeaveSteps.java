package org.example.stepdefs;

import io.cucumber.java.en.Then;
import org.example.context.TestContext;
import org.example.pages.ScheduledLeavePage;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class LeaveSteps {

    private final TestContext testContext;

    public LeaveSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    private final LocalDate currentDate = LocalDate.now();
    private final LocalDate fromDate = currentDate.minusDays(32);

    @Then("Alice can set a date range")
    public void alice_can_set_a_date_range() {
        ScheduledLeavePage scheduledLeavePage = new ScheduledLeavePage(testContext.getPage());
        scheduledLeavePage.selectFromDate(fromDate);
        scheduledLeavePage.selectToDate(fromDate);
    }

    @Then("Alice can search for scheduled leave")
    public void alice_can_search_for_scheduled_leave() {
        ScheduledLeavePage scheduledLeavePage = new ScheduledLeavePage(testContext.getPage());
        scheduledLeavePage.search();
        // TODO: the grid exists when the page is loaded so the assertion doesn't validate it sufficiently
        Assertions.assertTrue(scheduledLeavePage.isGridVisible());
    }
}
