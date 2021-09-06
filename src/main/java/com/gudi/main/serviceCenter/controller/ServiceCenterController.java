package com.gudi.main.serviceCenter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/serviceCenter")
public class ServiceCenterController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/NoticeBoard")
    public String NoticeBoard(Model model) {
        return "serviceCenter/NoticeBoard";
    }

    @RequestMapping(value = "/questionBoard")
    public String questionBoard(Model model) {
        return "serviceCenter/questionBoard";
    }
}
