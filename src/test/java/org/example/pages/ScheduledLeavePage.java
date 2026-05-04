package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class ScheduledLeavePage {

    private final Page page;

    public ScheduledLeavePage(Page page) {
        this.page = page;
    }


    public void selectFromDate(LocalDate date) {
        selectDate(date, 0);
    }

    public void selectToDate(LocalDate date) {
        selectDate(date, 1);
    }


    public void selectDate(LocalDate date, int dateInputIndex) {
        YearMonth targetYearMonth = YearMonth.from(date);
        //To avoid multiple calendar open
        Locator dateWrapper = page.locator(".oxd-date-wrapper").nth(dateInputIndex);
        dateWrapper.locator("i.oxd-date-input-icon").click();

        Locator calendar = dateWrapper.locator(".oxd-date-input-calendar");

        while (true) {
            String selectedMonth = calendar.locator(".oxd-calendar-selector-month-selected").innerText().trim();
            String selectedYear = calendar.locator(".oxd-calendar-selector-year-selected").innerText().trim();

            Month currentMonth = parseMonth(selectedMonth);
            int currentYear = Integer.parseInt(selectedYear);
            YearMonth currentYearMonth = YearMonth.of(currentYear, currentMonth);

            if (currentYearMonth.equals(targetYearMonth)) {
                var html = page.content();
                break;
            }

//            System.out.println(page.locator(".oxd-calendar-wrapper").innerHTML());
            if (currentYearMonth.isBefore(targetYearMonth)) {
                calendar.locator(".oxd-calendar-header button").nth(1).click();
            } else {
                calendar.locator(".oxd-calendar-header button").nth(0).click();
            }
        }
//        page.locator("//div[@class='oxd-calendar-date']/div[text()='" + date.getDayOfMonth() + "']").click();
        calendar.locator(".oxd-calendar-date:text-is('" + date.getDayOfMonth() + "')").click();

        String expectedDate = date.format(DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        String actualDate = page.locator("input[placeholder='yyyy-dd-mm']").nth(dateInputIndex).inputValue();

        Assertions.assertEquals(expectedDate, actualDate);
    }

    public void search()
    {
        page.locator("button[type='submit']").click();
    }

    public Boolean isGridVisible()
    {
        return page.locator(".orangehrm-bottom-container").isVisible();
    }

    private Month parseMonth(String monthText) {
        for (Month month : Month.values()) {
            if (month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).equalsIgnoreCase(monthText)
                    || month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).equalsIgnoreCase(monthText)) {
                return month;
            }
        }
        throw new IllegalArgumentException("Unknown month: " + monthText);
    }
}
