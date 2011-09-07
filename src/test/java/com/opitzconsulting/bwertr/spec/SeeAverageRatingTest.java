package com.opitzconsulting.bwertr.spec;

public class SeeAverageRatingTest extends AbstractSpringBwertrSpec {

    public String averageRatingFor(String listOfRatings) {
        resetBwertr();
        create(listOfRatings);
        bwertrDriver.visitResults();
        return bwertrDriver.getResultsPage().averageRatingShown();
    }

    private void create(String listOfRatings) {
        if (!listOfRatings.isEmpty())
            for (String rating : listOfRatings.split(","))
                bwertrDriver.rateWith(rating);
    }

}