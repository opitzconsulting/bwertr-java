package com.opitzconsulting.bwertr.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowNumberOfRatingsTest extends AbstractSpringBwertrSpec {

    public String numberOfRatingsShownWhenThereAre(int numberOfRatings) {
        ensureNumberOfRatingsExist(numberOfRatings);
        bwertrDriver.visitBwertr();
        return bwertrDriver.numberOfRatingsShown();
    }

    private void ensureNumberOfRatingsExist(int numberOfRatings) {
        resetBwertr();
        for (int i = 0; i < numberOfRatings; i++) {
            bwertrDriver.rateWith("Average");
        }
    }

}
