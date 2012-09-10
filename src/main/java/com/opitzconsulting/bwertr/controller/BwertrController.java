package com.opitzconsulting.bwertr.controller;

import com.opitzconsulting.bwertr.model.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Map<String, Object> model) {
        model.put("numberOfRatings", presentation.numberOfRatings());
        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String rate(String rating, Map<String, Object> model) {
        presentation.addRating(rating);
        model.put("givenRating", rating);
        return "thankYou";
    }

}
