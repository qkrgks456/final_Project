package com.gudi.main.campingTalk.freeBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/campingTalk")
public class FreeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/freeBoard")
    public String freeBoard(Model model) {
        return "campingTalk/freeBoard/freeBoardList";
    }
}
