package com.opitzconsulting.bwertr.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PresentationTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private Ratings ratings;
    @InjectMocks
    private Presentation presentation;

    @Test
    public void averageRating_givenRatingOne_returnsTextForOne() throws Exception {
        givenRatings(1);
        givenTextForValue(1, "One");

        assertThat(presentation.averageRating(), is("One"));
    }

    @Test
    public void averageRating_givenRatingOneAndThree_returnsTextForTwo() throws Exception {
        givenRatings(1, 3);
        givenTextForValue(2, "Two");

        assertThat(presentation.averageRating(), is("Two"));
    }

    @Test
    public void averageRating_givenRatingOneAndTwo_returnsTextForTwo() throws Exception {
        givenRatings(1, 2);
        givenTextForValue(2, "Two");

        assertThat(presentation.averageRating(), is("Two"));
    }

    private void givenTextForValue(int value, String text) {
        when(ratings.textFor(value)).thenReturn(text);
    }

    private void givenRatings(Integer... ratings) {
        when(jdbcTemplate.queryForList(anyString(), eq(Integer.class))).thenReturn(asList(ratings));
    }
}
