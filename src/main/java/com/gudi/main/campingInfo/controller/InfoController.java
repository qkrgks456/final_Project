package com.gudi.main.campingInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/campingInfo")
public class InfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/campingParking")
    public String campingParking(Model model) {
        return "campingInfo/campingParking";
    }

    @RequestMapping(value = "/campingRecipe")
    public String campingRecipe(Model model) {
        return "campingInfo/campingRecipe";
    }

    @RequestMapping(value = "/campingTip")
    public String campingTip(Model model) {
        return "campingInfo/campingTip";
    }

    @RequestMapping(value = "/campingWeather")
    public String list(Model model) {
        return "campingInfo/campingWeather";
    }


}
