package com.opitzconsulting.bwertr.model;

import java.util.List;

public interface Presentation {

    List<String> possibleRatings();

    void addRating(String rating);

    int numberOfRatings();

    String averageRating();

}
