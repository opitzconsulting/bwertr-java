package com.opitzconsulting.bwertr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JdbcPresentation implements Presentation {

    private final JdbcTemplate jdbcTemplate;
    private final Ratings ratings;

    @Autowired
    public JdbcPresentation(JdbcTemplate jdbcTemplate, Ratings ratings) {
        this.jdbcTemplate = jdbcTemplate;
        this.ratings = ratings;
    }

    public List<String> possibleRatings() {
        return ratings.possibleRatings();
    }

    public void addRating(String rating) {
        jdbcTemplate.update("INSERT INTO RATINGS (RATING) VALUES (?)", ratings.valueOf(rating));
    }

    public int numberOfRatings() {
        return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM RATINGS");
    }

    public String averageRating() {
        List<Map<String, Object>> allRatings = allRatings();
        if (allRatings.isEmpty())
            return ratings.textForUnknown();
        return ratings.textFor(averageOf(allRatings));
    }

    private List<Map<String, Object>> allRatings() {
        return jdbcTemplate.queryForList("SELECT * FROM RATINGS");
    }

    private int averageOf(List<Map<String, Object>> someRatings) {
        return (int) Math.round((double) sumOf(someRatings) / someRatings.size());
    }

    private int sumOf(List<Map<String, Object>> someRatings) {
        int sumOfRatings = 0;
        for (Map<String, Object> rowWithRating : someRatings) {
            sumOfRatings += (Integer) rowWithRating.get("RATING");
        }
        return sumOfRatings;
    }

}