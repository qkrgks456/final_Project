package com.gudi.main.campingInfo.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gudi.main.campingInfo.parking.service.ParkingService;

@Controller
@RequestMapping(value = "/campingInfo")
public class ParkingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired ParkingService service;
    
    @RequestMapping(value = "/campingParking")
    public String campingParking(Model model) {
    	
    	service.test();
    	
        return "campingInfo/campingParking/campingParkingMain";
    }

    


}
