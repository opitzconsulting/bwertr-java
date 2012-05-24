package com.opitzconsulting.bwertr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Controller
public class BwertrController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ModelAttribute("possibleRatings")
    public List<String> possibleRatings() {
        return asList("Poor", "Average", "Excellent");
    }

    @SuppressWarnings({"unchecked"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Map model) {
        model.put("numberOfRatings", jdbcTemplate.queryForInt("SELECT COUNT(*) FROM RATINGS"));
        return "welcome";
    }

    @SuppressWarnings({"unchecked"})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String rate(@RequestParam String rating, Map model) {
        model.put("givenRating", rating);
        return "thankYou";
    }

}