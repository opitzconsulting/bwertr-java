package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {

    private final WebDriver webDriver;

    public ResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String averageRatingShown() {
        return webDriver.findElement(By.id("averageRating")).getText();
    }
}
