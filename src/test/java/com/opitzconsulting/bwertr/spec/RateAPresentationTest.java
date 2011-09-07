package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RateAPresentationTest extends AbstractBwertrSpec {

    public String ratingShownAfterRatingWith(String rating) {
        // Rate with rating
        // * Visit bwertr
        WebDriver webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:8080");
        // * Select option and submit
        WebElement option = webDriver.findElement(By.id(rating));
        option.setSelected();
        option.submit();
        // Return rating shown
        return webDriver.findElement(By.id("givenRating")).getText();
    }

}