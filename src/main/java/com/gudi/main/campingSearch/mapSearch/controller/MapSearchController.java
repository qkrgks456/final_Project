package com.gudi.main.campingSearch.mapSearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/campingSearch")
public class MapSearchController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/mapSearch")
    public String mapSearch(Model model) {
        return "campingSearch/mapSearch/mapSearchMain";
    }
}
