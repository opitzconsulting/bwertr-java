package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage {

    private final WebDriver webDriver;

    public ThankYouPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String ratingShown() {
        return webDriver.findElement(By.id("givenRating")).getText();
    }
}