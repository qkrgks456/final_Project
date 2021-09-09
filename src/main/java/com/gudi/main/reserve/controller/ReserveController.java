package com.gudi.main.reserve.controller;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.reserve.service.ReserveService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reserve")
public class ReserveController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ReserveService service;
    @RequestMapping(value = "/campingDetail")
    public String myInfo(Model model) {
        BoardDTO dto = service.test();
        model.addAttribute("dto",dto);
        return "reserve/campingDetail";
    }
}
