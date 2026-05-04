package org.example.stepdefs;

import io.cucumber.java.en.Then;
import org.example.context.TestContext;
import org.example.pages.ScheduledLeavePage;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class LeaveSteps {

    private final LocalDate currentDate = LocalDate.now();
    private final LocalDate fromDate = currentDate.minusDays(32);
    ScheduledLeavePage scheduledLeavePage = new ScheduledLeavePage(TestContext.getPage());

    @Then("Alice can set a date range")
    public void alice_can_set_a_date_range() {
        scheduledLeavePage.selectFromDate(fromDate);
        scheduledLeavePage.selectToDate(fromDate);
    }

    @Then("Alice can search for scheduled leave")
    public void alice_can_search_for_scheduled_leave() {
        scheduledLeavePage.search();
        // TODO: the grid exists when the page is loaded so the assertion doesn't validate it sufficiently
        // but it is what the task asked for
        Assertions.assertTrue(scheduledLeavePage.isGridVisible());
    }
}
