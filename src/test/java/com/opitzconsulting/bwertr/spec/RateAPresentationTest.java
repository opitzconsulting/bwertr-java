package com.opitzconsulting.bwertr.spec;

public class RateAPresentationTest extends AbstractBwertrSpec {

    public String ratingShownAfterRatingWith(String rating) {
        bwertrDriver.rateWith(rating);
        return bwertrDriver.getThankYouPage().ratingShown();
    }

}