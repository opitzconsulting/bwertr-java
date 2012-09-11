package com.opitzconsulting.bwertr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPresentation implements Presentation {

    private JdbcTemplate jdbcTemplate;

    private Ratings ratings;

    @Autowired
    public JdbcPresentation(JdbcTemplate jdbcTemplate, Ratings ratings) {
        this.jdbcTemplate = jdbcTemplate;
        this.ratings = ratings;
    }

    @Override
    public List<String> possibleRatings() {
        return ratings.possibleRatings();
    }

    @Override
    public void addRating(String rating) {
        jdbcTemplate.update("INSERT INTO RATINGS(RATING) VALUES (?)", ratings.valueOf(rating));
    }

    @Override
    public int numberOfRatings() {
        return jdbcTemplate.queryForInt("SELECT COUNT(1) FROM RATINGS");
    }

    @Override
    public String averageRating() {
        return ratings.textFor(averageOf(allRatings()));
    }

    private List<Integer> allRatings() {
        return jdbcTemplate.queryForList("SELECT RATING FROM RATINGS", Integer.class);
    }

    private int sumOf(List<Integer> ratings) {
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum;
    }

    private int averageOf(List<Integer> ratings) {
        return (int) Math.round((double) sumOf(ratings) / ratings.size());
    }
}