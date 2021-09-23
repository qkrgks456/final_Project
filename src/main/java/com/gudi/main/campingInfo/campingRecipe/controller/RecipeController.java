package com.gudi.main.campingInfo.campingRecipe.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudi.main.campingInfo.campingRecipe.service.RecipeService;

@Controller
@RequestMapping(value = "/campingInfo")
public class RecipeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired RecipeService service;
    
    @RequestMapping(value = "/campingRecipe")
    public String campingRecipe(Model model) {
        return "campingInfo/campingRecipe";
    }
    
    @ResponseBody
    @RequestMapping(value = "/RecipeApi")
    public HashMap<String, Object> test(@RequestParam HashMap<String, String> params) {
    	logger.info("params : {}",params);		
        return service.RecipeApi(params);
    }
}