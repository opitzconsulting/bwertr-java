package com.opitzconsulting.bwertr.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdbcPresentationTest {

    private Ratings ratings;
    private JdbcTemplate jdbcTemplate;
    private JdbcPresentation presentation;

    @Before
    public void setUp() throws Exception {
        ratings = mock(Ratings.class);
        jdbcTemplate = mock(JdbcTemplate.class);
        presentation = new JdbcPresentation(jdbcTemplate, ratings);
    }

    @Test
    public void averageRating_forRatingOne_isTextForOne() {
        String textForOne = "textForOne";
        givenRatings(1);
        andTextForRating(textForOne, 1);
        assertThat(presentation.averageRating(), is(textForOne));
    }

    @Test
    public void averageRating_forRatingsOneAndThree_isTextForTwo() {
        String textForTwo = "foo";
        givenRatings(1, 3);
        andTextForRating(textForTwo, 2);
        assertThat(presentation.averageRating(), is(textForTwo));
    }

    @Test
    public void averageRating_forRatingsOneAndTwo_isTextForTwo() {
        String textForTwo = "textForTwo";
        givenRatings(1, 2);
        andTextForRating(textForTwo, 2);
        assertThat(presentation.averageRating(), is(textForTwo));
    }

    @Test
    public void averageRating_forNoRatings_isTextForUnknown() {
        String textForUnknown = "textForUnknown";
        givenNoRatings();
        andTextForUnknown(textForUnknown);
        assertThat(presentation.averageRating(), is(textForUnknown));
    }

    private void givenRatings(int... someRatings) {
        List<Map<String, Object>> resultWithRatings = new ArrayList<Map<String, Object>>();
        for (int rating : someRatings) {
            Map<String, Object> rowWithRating = new HashMap<String, Object>();
            rowWithRating.put("RATING", rating);
            resultWithRatings.add(rowWithRating);
        }
        when(jdbcTemplate.queryForList(anyString())).thenReturn(resultWithRatings);
    }

    private void givenNoRatings() {
        givenRatings();
    }

    private void andTextForRating(String text, int rating) {
        when(ratings.textFor(rating)).thenReturn(text);
    }

    private void andTextForUnknown(String text) {
        when(ratings.textForUnknown()).thenReturn(text);
    }

}
