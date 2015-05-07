package com.opitzconsulting.bwertr.spec;

public class SeeAverageRatingTest extends AbstractSpringBwertrSpec {

    public String averageRatingFor(String listOfRatings) {
        resetBwertr();
        for (String rating : listOfRatings.split(",")) {
            bwertrDriver.rateWith(rating);
        }
        return bwertrDriver.averageRatingShown();
    }

}
