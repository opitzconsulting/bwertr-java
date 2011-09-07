package com.opitzconsulting.bwertr.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PoorAverageExcellentUnknown implements Ratings {
    public List<String> possibleRatings() {
        return Arrays.asList("Poor", "Average", "Excellent");
    }

    public int valueOf(String rating) {
        return possibleRatings().indexOf(rating);
    }

    public String textFor(int value) {
        return possibleRatings().get(value);
    }

    public String textForUnknown() {
        return "Unknown";
    }
}