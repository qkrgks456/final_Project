package com.gudi.main.campingInfo.campingRecipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/campingInfo")
public class RecipeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/campingRecipe")
    public String campingRecipe(Model model) {
        return "campingInfo/campingRecipe";
    }
}
