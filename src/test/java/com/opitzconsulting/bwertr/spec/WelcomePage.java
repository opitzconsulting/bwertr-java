package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {

    private final WebDriver webDriver;

    public WelcomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void rateWith(String rating) {
        Select select = new Select(webDriver.findElement(By.id(rating)));
        select.selectByValue(rating);
        select.getFirstSelectedOption().submit();
    }

    public String numberOfRatingsShown() {
        return webDriver.findElement(By.id("numberOfRatings")).getText();
    }
}