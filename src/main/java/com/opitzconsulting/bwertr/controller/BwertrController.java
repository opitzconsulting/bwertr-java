package com.opitzconsulting.bwertr.controller;

import com.opitzconsulting.bwertr.model.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BwertrController {

    @Autowired
    private Presentation presentation;

    @ModelAttribute("possibleRatings")
    public List<String> possibleRatings() {
        return presentation.possibleRatings();
    }

    @SuppressWarnings({"unchecked"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Map model) {
        model.put("numberOfRatings", presentation.numberOfRatings());
        return "welcome";
    }

    @SuppressWarnings({"unchecked"})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String rate(@RequestParam String rating, Map model) {
        presentation.addRating(rating);
        model.put("givenRating", rating);
        return "thankYou";
    }

    @SuppressWarnings({"unchecked"})
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(Map model) {
        model.put("averageRating", presentation.averageRating());
        return "results";
    }

}