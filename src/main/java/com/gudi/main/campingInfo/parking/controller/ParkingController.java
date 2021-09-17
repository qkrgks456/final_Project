package com.gudi.main.campingInfo.parking.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
import com.gudi.main.cm.CmService;
import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.dtoAll.ParkingDTO;
import com.gudi.main.reserve.dao.GoodMapper;
import com.gudi.main.reserve.service.GoodService;

@Controller
@RequestMapping(value = "/campingInfo")
public class ParkingController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired ParkingService service;
    @Autowired CmService cmService;
    @Autowired GoodMapper goodMapper;
    
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
    	System.out.println(dto.get(0).getLatitude());
    	System.out.println(dto.get(0).getLongitude());
    	
        return dto;
    }
    
    @RequestMapping(value = "/freeParkDetail/{prkplcenm}")
    @ResponseBody
    public ModelAndView freeParkDetail (@PathVariable String prkplcenm, HttpSession session) {
    	String loginId = (String) session.getAttribute("loginId");
    	logger.info("차박지도 상세보기:: "+ prkplcenm);
    	
    	ModelAndView mav = new ModelAndView();
    	
    	//주차장 상세정보
    	ParkingDTO dto = service.freeParkDetail(prkplcenm);
    	
    	
    	//댓글 불러옴
	    HashMap<String, Object> map = cmService.cmList("000000", prkplcenm, 1);
	    
	    //총 추천수 불러옴
    	map.put("goodCount",goodMapper.goodCount("000000",prkplcenm));
    	
    	//내가 추천했는지 체크
    	String check = null;
    	if(loginId != null) {
    		check = goodMapper.goodCheck("000000", "review", loginId);
    	}
    	if (check == null) { 
            map.put("goodCheck", true);
        } else { 
            map.put("goodCheck", false);
        }
	    
    	mav.addObject("map",map);
    	mav.addObject("dto",dto);
    	mav.setViewName("/campingInfo/campingParking/freeParkDetail");
        
    	return mav;
    }
    
    
    @RequestMapping(value = "/payPark")
    public String payPark(Model model) {
    	logger.info("차박 유료지도 메인 불러오셈::");
        return "campingInfo/campingParking/payParkingMain";
    }
    
    @RequestMapping(value = "/payZapyo")
    @ResponseBody
    public ArrayList<CampingDTO> payZapyo(@RequestParam HashMap<String, Object> map) {
    	logger.info("차박 유료지도 메인 불러오셈::");
    	System.out.println("넘어온 좌표는??::"+map); //{wido=36.499425535542095, kyongdo=127.66112788120117}
    	
    	ArrayList<CampingDTO> dto = service.payZapyo(map);
    	//mapX 가 위도 mapY 가 경도
    	
    	System.out.println("dto는??:: "+dto);
    	System.out.println("dto 사이즈는??:: "+dto.size());
    	
    	System.out.println(dto.get(0).getMapX()); //위도
    	System.out.println(dto.get(0).getMapY()); //경도
    	
        return dto;
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
