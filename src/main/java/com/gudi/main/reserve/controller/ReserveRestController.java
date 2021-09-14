package com.gudi.main.reserve.controller;

import com.gudi.main.reserve.service.CommentService;
import com.gudi.main.reserve.service.GoodService;
import com.gudi.main.reserve.service.ReserveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/reserve")
public class ReserveRestController {
    @Autowired
    CommentService commentService;
    @Autowired
    GoodService goodService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/reserveCmInsert")
    public HashMap<String, Object> reserveCmInsert(HttpSession session, String commentContent, String contentId) {
        String loginId = (String) session.getAttribute("loginId");
        return commentService.reserveCmInsert(contentId, commentContent, loginId);
    }

    @RequestMapping(value = "/reserveCmUpdate")
    public HashMap<String, Object> reserveCmUpdate(HttpSession session, String cmNum, String contentId,String cmUpdateContent) {
        String loginId = (String) session.getAttribute("loginId");
        return commentService.reserveCmUpdate(cmNum,contentId,cmUpdateContent,loginId);
    }

    @RequestMapping(value = "/reserveCmList/{page}/{contentId}")
    public HashMap<String, Object> reserveCmList(HttpSession session, @PathVariable int page, @PathVariable String contentId) {
        String loginId = (String) session.getAttribute("loginId");
        HashMap<String, Object> map = commentService.commentList(contentId, "camping", page);
        map.put("loginId",loginId);
        return map;
    }

    @RequestMapping(value = "/reserveCmDelete")
    public HashMap<String, Object> reserveCmDelete(HttpSession session, String cmNum, String contentId) {
        String loginId = (String) session.getAttribute("loginId");
        return commentService.reserveCmDelete(cmNum,contentId,loginId);
    }
    @RequestMapping(value = "/campingGood")
    public HashMap<String, Object> campingGood(HttpSession session,String contentId) {
        String loginId = (String) session.getAttribute("loginId");
        return goodService.campingGood(contentId,loginId);
    }

}
