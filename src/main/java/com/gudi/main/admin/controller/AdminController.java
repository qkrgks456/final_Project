package com.gudi.main.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/adminSearch")
    public String adminSearch(Model model) {
        return "admin/authority/adminSearch";
    }
    @RequestMapping(value = "/adminInsert")
    public String adminInsert(Model model) {
        return "admin/authority/adminInsert";
    }
    @RequestMapping(value = "/memberInfo")
    public String memberInfo(Model model) {
        return "admin/list/memberInfo";
    }
    @RequestMapping(value = "/memberReserve")
    public String memberReserve(Model model) {
        return "admin/list/memberReserve";
    }
    @RequestMapping(value = "/boardList")
    public String boardList(Model model) {
        return "admin/list/boardList";
    }
    @RequestMapping(value = "/comment")
    public String comment(Model model) {
        return "admin/comment/comment";
    }
    @RequestMapping(value = "/reportComment")
    public String reportComment(Model model) {
        return "admin/comment/reportComment";
    }


}
