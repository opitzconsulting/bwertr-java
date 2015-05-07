package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class RateAPresentationTest extends AbstractBwertrSpec {

    public String ratingShownAfterRatingWith(String rating){
        // rate with rating
        // * visit bwertr
        WebDriver webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:8080/");
        // * select rating
        WebElement element = webDriver.findElement(By.id("rating"));
        Select select = new Select(element);
        select.selectByValue(rating);
        // * submit form
        select.getFirstSelectedOption().submit();
        // return given rating
        return webDriver.findElement(By.id("givenRating")).getText();
    }

}
