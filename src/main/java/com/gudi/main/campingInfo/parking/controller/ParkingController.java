package com.gudi.main.campingInfo.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/campingInfo")
public class ParkingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/campingParking")
    public String campingParking(Model model) {
        return "campingInfo/campingParking/campingParkingMain";
    }



}
