package com.opitzconsulting.bwertr.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Ratings {

    public List<String> possibleRatings() {
        return Arrays.asList("Poor", "Average", "Excellent");
    }

    public String textFor(int value) {
        return possibleRatings().get(value);
    }

    public int valueOf(String rating) {
        return possibleRatings().indexOf(rating);
    }
}
