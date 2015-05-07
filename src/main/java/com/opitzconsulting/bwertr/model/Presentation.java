package com.opitzconsulting.bwertr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Presentation {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<String> possibleRatingsForPresentation() {
        return Arrays.asList("Poor", "Average", "Excellent");
    }

    public void addRating(String rating) {
        jdbcTemplate.update("insert into RATINGS(RATING) values (?)", valueOf(rating));
    }

    private int valueOf(String rating) {
        return possibleRatingsForPresentation().indexOf(rating);
    }

    public Integer numberOfRatings() {
        return jdbcTemplate.queryForObject("select count(RATING) from RATINGS", Integer.class);
    }

}