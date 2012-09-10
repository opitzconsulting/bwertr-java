package com.opitzconsulting.bwertr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JdbcPresentation implements Presentation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> possibleRatings() {
        return Arrays.asList("Poor", "Average", "Excellent");
    }

    private int valueOf(String rating) {
        return possibleRatings().indexOf(rating);
    }

    @Override
    public void addRating(String rating) {
        jdbcTemplate.update("INSERT INTO RATINGS(RATING) VALUES (?)", valueOf(rating));
    }

    @Override
    public int numberOfRatings() {
        return jdbcTemplate.queryForInt("SELECT COUNT(1) FROM RATINGS");
    }
}