package com.gudi.main.reserve.controller;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.reserve.service.ReserveService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/reserve")
public class ReserveController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ReserveService service;
    @RequestMapping(value = "/campingDetail/{contentId}")
    public String myInfo(Model model,@PathVariable String contentId) {
        HashMap<String,Object> map = service.campingDetail(contentId);
        model.addAttribute("map",map);
        return "reserve/campingDetail";
    }

    @RequestMapping(value = "/campingReserve")
    public String campingReserveList(Model model) {
        return "reserve/campingReserve";
    }

    @RequestMapping(value = "/campingReserveForm")
    public String campingReserveForm(Model model) {
        return "reserve/campingReserveForm";
    }
}
