package com.gudi.main.campingServiceCenter.noticeBoard.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingServiceCenter.noticeBoard.service.NoticeService;

@Controller
@RequestMapping(value = "/serviceCenter")
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    NoticeService service;

    @RequestMapping(value = "/noticeBoard")
    public String NoticeBoard(Model model) {
        logger.info("공지사항입장");
        return "serviceCenter/noticeBoard/noticeBoardList";
    }

    @ResponseBody
    @RequestMapping(value = "/noticeBoardList/{pagePerNum}/{page}", method = RequestMethod.GET)
    public HashMap<String, Object> list(@PathVariable int pagePerNum, @PathVariable int page) {
        logger.info("공지사항 리스트");
        //@PathVariable 경로에 있는 녀석을 변수로 담는다.
        logger.info("pagePerNum : {} / page : {}", pagePerNum, page);
        HashMap<String, Object> map = service.list(page, pagePerNum);
        return map;
    }


    @RequestMapping(value = "/noticeDetail")
    public ModelAndView noticeDetail(@RequestParam String boardnum) {
        return service.detail(boardnum);
    }

}
