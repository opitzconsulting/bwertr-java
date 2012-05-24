package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class RateAPresentationTest extends AbstractBwertrSpec {

    public String ratingShownAfterRatingWith(String rating) {
        // Rate with rating
        // * Visit bwertr
        WebDriver webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:8080");
        // * Select option and submit
        Select select = new Select(webDriver.findElement(By.id("rating")));
        select.selectByValue(rating);
        select.getFirstSelectedOption().submit();
        // Return rating shown
        return webDriver.findElement(By.id("givenRating")).getText();
    }

}