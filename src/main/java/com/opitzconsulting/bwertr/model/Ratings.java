package com.opitzconsulting.bwertr.model;

import java.util.List;

public interface Ratings {
    String textFor(int value);

    String textForUnknown();

    List<String> possibleRatings();

    int valueOf(String rating);
}
