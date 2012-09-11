package com.opitzconsulting.bwertr.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PoorAverageExcellent implements Ratings {

    @Override
    public List<String> possibleRatings() {
        return Arrays.asList("Poor", "Average", "Excellent");
    }

    @Override
    public String textFor(int rating) {
        return possibleRatings().get(rating);
    }

    @Override
    public int valueOf(String rating) {
        return possibleRatings().indexOf(rating);
    }

}
