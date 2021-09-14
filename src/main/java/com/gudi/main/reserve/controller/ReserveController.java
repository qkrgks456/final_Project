package com.gudi.main.reserve.controller;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.dtoAll.ReserveDTO;
import com.gudi.main.reserve.service.ReserveService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/reserve")
public class ReserveController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ReserveService service;

    @RequestMapping(value = "/campingDetail/{contentId}")
    public String myInfo(Model model, @PathVariable String contentId, HttpSession session) {
        HashMap<String, Object> map = service.campingDetail(contentId, session);
        model.addAttribute("map", map);
        return "reserve/campingDetail";
    }

    @RequestMapping(value = "/campingReserveForm/{contentId}")
    public String campingReserveList(@PathVariable String contentId, Model model) {
        service.campingReserveList(contentId);
        model.addAttribute("contentId", contentId);
        return "reserve/campingReserveForm";
    }

    @RequestMapping(value = "/campingReserve/{contentId}")
    public String campingReserve(@PathVariable String contentId, @RequestParam ArrayList<String> reserveDate,
                                 String phone, String manCount, String carNum, String reserveName, HttpSession session) {
        String loginId = (String) session.getAttribute("loginId");
        ReserveDTO dto = new ReserveDTO();
        dto.setPhone(phone);
        dto.setManCount(manCount);
        dto.setCarNum(carNum);
        dto.setReserveName(reserveName);
        dto.setContentId(contentId);
        dto.setId(loginId);
        /*service.campingReserveInsert(dto, reserveDate);*/
        return "reserve/campingResult";
    }

}
