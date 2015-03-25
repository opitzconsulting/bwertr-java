package com.opitzconsulting.bwertr.spec;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public abstract class AbstractSpringBwertrSpec extends AbstractBwertrSpec {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected void resetBwertr() {
        jdbcTemplate.update("DELETE FROM RATINGS");
    }

}
