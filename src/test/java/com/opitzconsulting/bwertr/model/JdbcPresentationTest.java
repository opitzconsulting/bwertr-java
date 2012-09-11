package com.opitzconsulting.bwertr.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdbcPresentationTest {

    private JdbcTemplate jdbcTemplate;
    private Ratings ratings;
    private JdbcPresentation jdbcPresentation;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate = mock(JdbcTemplate.class);
        ratings = mock(Ratings.class);
        jdbcPresentation = new JdbcPresentation(jdbcTemplate, ratings);
    }

    @Test
    public void averageRating_givenRatingOne_returnsTextForOne() {
        String textForOne = "one";
        givenRatings(1);
        givenTextForValue(1, textForOne);
        assertEquals(textForOne, jdbcPresentation.averageRating());
    }

    @Test
    public void averageRating_givenRatingOneAndThree_returnsTextForTwo() {
        String textForTwo = "two";
        givenRatings(1, 3);
        givenTextForValue(2, textForTwo);
        assertEquals(textForTwo, jdbcPresentation.averageRating());
    }

    @Test
    public void averageRating_givenRatingOneAndTwo_returnsTextForTwo() {
        String textForTwo = "two";
        givenRatings(1, 2);
        givenTextForValue(2, textForTwo);
        assertEquals(textForTwo, jdbcPresentation.averageRating());
    }

    private OngoingStubbing<List<Integer>> givenRatings(Integer... ratings) {
        return when(jdbcTemplate.queryForList(anyString(), eq(Integer.class))).thenReturn(asList(ratings));
    }

    private OngoingStubbing<String> givenTextForValue(int value, String text) {
        return when(ratings.textFor(value)).thenReturn(text);
    }
}
