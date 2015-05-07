package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowNumberOfRatingsTest extends AbstractSpringBwertrSpec {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String numberOfRatingsShownWhenThereAre(int numberOfRatings) {
        // ensure number of ratings exist
        // * clean database
        jdbcTemplate.update("DELETE FROM RATINGS");
        // * create ratings
        for (int i = 0; i < numberOfRatings; i++) {
            jdbcTemplate.update("INSERT INTO RATINGS values(?)", 1);
        }
        // visit bwertr
        WebDriver webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:8080/");
        // return numberOfRatings shown
        WebElement numberOfRatingsElement = webDriver.findElement(By.id("numberOfRatings"));
        return numberOfRatingsElement.getText();
    }

}
