package com.opitzconsulting.bwertr.spec;

public class ShowNumberOfRatingsTest extends AbstractSpringBwertrSpec {

    public String numberOfRatingsShownWhenThereAre(int numberOfRatings) {
        ensureNumberOfRatingsExist(numberOfRatings);
        bwertrDriver.visitBwertr();
        return bwertrDriver.getWelcomePage().numberOfRatingsShown();
    }

    private void ensureNumberOfRatingsExist(int numberOfRatings) {
        resetBwertr();
        for (int count = 0; count < numberOfRatings; count ++) {
            bwertrDriver.rateWith("Poor");
        }
    }

}
