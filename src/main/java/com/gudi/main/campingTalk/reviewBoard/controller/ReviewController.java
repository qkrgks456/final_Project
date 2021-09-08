package com.gudi.main.campingTalk.reviewBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/campingTalk")
public class ReviewController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/reviewBoard")
    public String reviewBoard(Model model) {
        return "campingTalk/reviewBoard/reviewBoardList";
    }
}