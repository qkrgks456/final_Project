package com.gudi.main.reserve.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reserve")
public class ReserveController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/campingDetail")
    public String myInfo() {
        return "reserve/campingDetail";
    }
}
