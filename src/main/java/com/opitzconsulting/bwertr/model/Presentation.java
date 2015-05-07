package com.opitzconsulting.bwertr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Presentation {

    private JdbcTemplate jdbcTemplate;
    private Ratings ratings;

    @Autowired
    public Presentation(JdbcTemplate jdbcTemplate, Ratings ratings) {
        this.jdbcTemplate = jdbcTemplate;
        this.ratings = ratings;
    }

    public List<String> possibleRatings() {
        return ratings.possibleRatings();
    }

    public void addRating(String rating) {
        jdbcTemplate.update("insert into RATINGS(RATING) values (?)", ratings.valueOf(rating));
    }

    public Integer numberOfRatings() {
        return jdbcTemplate.queryForObject("select count(RATING) from RATINGS", Integer.class);
    }

    public String averageRating() {
        return ratings.textFor(averageOf(allRatings()));
    }

    private int averageOf(List<Integer> ratings) {
        return (int) Math.round((double) sumOf(ratings) / ratings.size());
    }

    private int sumOf(List<Integer> ratings) {
        int sum = 0;
        for (Integer rating : ratings) {
            sum+=rating;
        }
        return sum;
    }

    private List<Integer> allRatings() {
        return jdbcTemplate.queryForList("SELECT RATING FROM RATINGS", Integer.class);
    }
}