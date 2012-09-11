package com.opitzconsulting.bwertr.spec;

public class RateAPresentationTest extends AbstractBwertrSpec {

    @SuppressWarnings("UnusedDeclaration")
    public String ratingShownAfterRatingWith(String rating) {
        bwertrDriver.rateWith(rating);
        return bwertrDriver.givenRatingShown();
    }

}