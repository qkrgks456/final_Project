package com.gudi.main.campingServiceCenter.noticeBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingServiceCenter.noticeBoard.service.NoticeService;

@Controller
@RequestMapping(value = "/serviceCenter")
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired NoticeService service;

    @RequestMapping(value = "/noticeBoard")
    public ModelAndView NoticeBoard() {
        return service.list();
    }
    
    @RequestMapping(value = "/noticeDetail")
    public ModelAndView noticeDetail(@RequestParam String boardnum) {
        return service.detail(boardnum);
    }

}
