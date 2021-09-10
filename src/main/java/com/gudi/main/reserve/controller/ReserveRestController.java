package com.gudi.main.reserve.controller;

import com.gudi.main.reserve.service.CommentService;
import com.gudi.main.reserve.service.ReserveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/reserve")
public class ReserveRestController {
    @Autowired
    ReserveService reserveService;
    @Autowired
    CommentService commentService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/reserveCmInsert")
    public HashMap<String, Object> reserveCmInsert(HttpSession session, String commentContent, String contentId) {
        String loginId = (String) session.getAttribute("loginId");
        commentService.reserveCmInsert(contentId, commentContent,loginId);
        return null;
    }

}
