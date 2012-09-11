package com.opitzconsulting.bwertr.model;

import java.util.List;

public interface Ratings {

    String textFor(int rating);

    List<String> possibleRatings();

    int valueOf(String rating);

}
