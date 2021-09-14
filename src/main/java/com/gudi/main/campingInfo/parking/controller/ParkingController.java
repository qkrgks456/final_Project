package com.gudi.main.campingInfo.parking.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingInfo.parking.service.ParkingService;
import com.gudi.main.dtoAll.ParkingDTO;

@Controller
@RequestMapping(value = "/campingInfo")
public class ParkingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired ParkingService service;
    
    @RequestMapping(value = "/campingParking")
    public String campingParking(Model model) {
    	logger.info("차박지도 메인 불러오셈::");
        return "campingInfo/campingParking/campingParkingMain";
    }
    

    @RequestMapping(value = "/getZapyo")
    @ResponseBody
    public ArrayList<ParkingDTO> getZapyo(@RequestParam HashMap<String, Object> map) {
    	
    	System.out.println("넘어온 좌표는??::"+map); //{wido=36.499425535542095, kyongdo=127.66112788120117}
    	
    	ArrayList<ParkingDTO> dto = service.getZapyo(map);
    	
    	System.out.println("dto는??:: "+dto);
    	//ArrayList<ParkingDTO> dto = [class(key=value),class(key=value)]
    	System.out.println("dto 사이즈는??:: "+dto.size());
    	
    	System.out.println(dto.get(0).getLATITUDE());
    	System.out.println(dto.get(0).getLONGITUDE());
    	
        return dto;
    }
    
    @RequestMapping(value = "/freeParkDetail/{prkplcenm}")
    public ModelAndView freeParkDetail (@PathVariable String prkplcenm) {
    	logger.info("차박지도 상세보기:: "+ prkplcenm);
    	
    	ModelAndView mav = new ModelAndView();
    	
    	ParkingDTO dto = service.freeParkDetail(prkplcenm);
    	
    	mav.addObject("dto",dto);
    	mav.setViewName("/campingInfo/campingParking/freeParkDetail");
        
    	return mav;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    @RequestMapping(value = "/apiCall")
    @ResponseBody
    public void apiCall(
    		@RequestParam HashMap<String, String> params) {
    	System.out.println("db작업확인???:::");
        service.apiCall(params);
    }
	*/

}
